package com.example.municipalapp.feature_business.presesntation.businesses.component

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.feature_business.presesntation.businesses.BusinessesViewModel
import com.example.municipalapp.ui.theme.BackColor
import com.example.municipalapp.ui.theme.HotRed
import com.example.municipalapp.ui.theme.TopColor
import kotlinx.coroutines.launch
import java.time.ZonedDateTime
import java.util.UUID

/**
 * Created by Stephen Obeng Takyi on 06/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessesScreen(
    navController: NavController,
    viewModel: BusinessesViewModel = hiltViewModel()
) {

    val state = viewModel.state.value
    val snackBarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    val tempList: List<Business> = listOf(
        Business(
            businessName = "FAFALI ENTERPRISE",
            businessOperatingPermitCode = "GHA-567GHJ",
            category = UUID.randomUUID(),
            createdAt = ZonedDateTime.now(),
            createdBy = "Nana",
        ),
        Business(
            businessName = "SISTERS FAST FOOD",
            businessOperatingPermitCode = "GHA-567GHJ",
            category = UUID.randomUUID(),
            createdAt = ZonedDateTime.now(),
            createdBy = "Nana",
        ),
        Business(
            businessName = "JOHN DOE MEMORIAL",
            businessOperatingPermitCode = "GHA-567GHJ",
            category = UUID.randomUUID(),
            createdAt = ZonedDateTime.now(),
            createdBy = "Nana",
        ),
        Business(
            businessName = "CADDY COLD STORE",
            businessOperatingPermitCode = "GHA-567GHJ",
            category = UUID.randomUUID(),
            createdAt = ZonedDateTime.now(),
            createdBy = "Nana",
        ),
        Business(
            businessName = "JAPA LIMITED",
            businessOperatingPermitCode = "GHA-567GHJ",
            category = UUID.randomUUID(),
            createdAt = ZonedDateTime.now(),
            createdBy = "Nana",
        )
    )

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = { Text(text = "Businesses", color = TopColor) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = HotRed
                ),
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = "Search",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                    IconButton(onClick = { /*TODO*/ }) {
                        Icon(
                            imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu",
                            tint = MaterialTheme.colorScheme.surface
                        )
                    }
                })
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = HotRed,
                shape = RoundedCornerShape(10.dp)
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = TopColor,
                    contentDescription = "Add Business",
                )
            }
        },
        snackbarHost = { SnackbarHost(snackBarHostState) },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = it)
                    .background(
                        BackColor
                    )
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
//                items(state.businesses) { business ->
                    items(tempList) { business ->
                        BusinessListItem(
                            business = business,
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { },
                            onPaymentConfirmation = {
                                scope.launch {
                                    snackBarHostState.showSnackbar(
                                        "Payment Made"
                                    )
                                }
                            }
                        )
                    }
                }
            }
        })

}