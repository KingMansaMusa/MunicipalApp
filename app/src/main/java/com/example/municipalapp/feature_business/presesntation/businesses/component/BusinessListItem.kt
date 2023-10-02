package com.example.municipalapp.feature_business.presesntation.businesses.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.municipalapp.feature_business.domain.model.Business
import com.example.municipalapp.ui.theme.SweetGreen
import com.example.municipalapp.ui.theme.TopColor

/**
 * Created by Stephen Obeng Takyi on 06/09/2023,
 * Supertech (STL) Ghana Limited,
 * stephenta@stlghana.com.
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusinessListItem(
    business: Business,
    modifier: Modifier,
    onPaymentConfirmation: () -> Unit
) {

    Card(
        modifier = Modifier.padding(10.dp),
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(TopColor)
    ) {
        Row(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            verticalAlignment = CenterVertically
        ) {
            Box(modifier = Modifier.weight(0.1f), contentAlignment = Center) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Shop")
            }
            Column(modifier = Modifier
                .padding(10.dp)
                .weight(0.8f)
                .fillMaxWidth()) {

                Text(
                    text = business.businessName,
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Text(
                    text = business.businessOperatingPermitCode,
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.outline
                )

                Text(
                    text = business.category.toString(),
                    fontWeight = FontWeight.Normal,
                    fontSize = 12.sp,
                    color = MaterialTheme.colorScheme.outline
                )

            }
            IconButton(
                onClick = { onPaymentConfirmation },
                modifier = Modifier
                    .weight(0.1f)
                    .align(CenterVertically)
                    .clickable { onPaymentConfirmation }
                    .background(SweetGreen.copy(alpha = 0.2f), shape = RoundedCornerShape(10.dp))) {
                Icon(
                    imageVector = Icons.Filled.PlayArrow,
                    contentDescription = "Pay Amount",
                    tint = SweetGreen
                )
            }
        }
    }

}