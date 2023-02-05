package com.sachin.jobapp.presentation.screen

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sachin.jobapp.model.JobPostModalItem
import com.sachin.jobapp.ui.theme.darkBlue
import java.net.ConnectException

@Composable
fun HomeScreen() {
    val homeViewModel = viewModel(modelClass = HomeViewModel::class.java)
    val state by homeViewModel.state.collectAsState()
    //val state = remember { Details.JobDetailsList}
   if(state.isNotEmpty()){
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(
            state
        ) {
            JobCard(jobPost = it)
        }
    }
   }else{
       if (state.isEmpty()) {
           try {

           }catch (e: ConnectException){
               Log.e("Error:","Server Down")
           }
       }
       Column(modifier = Modifier.fillMaxSize(),
           verticalArrangement = Arrangement.Center,
           horizontalAlignment = Alignment.CenterHorizontally) {
           Button(onClick = { /*TODO*/ }) {
               Text("No Data Found")
           }
       }
   }
}
@Composable
fun JobCard(jobPost: JobPostModalItem){
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        elevation = 8.dp,
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row(modifier = Modifier.padding(20.dp)) {
            Column(modifier = Modifier.weight(1f),
                Arrangement.Center) {
                Text(
                    text = jobPost.jobtitle,
                    style = TextStyle(
                        color = darkBlue,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                    )
                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = darkBlue, fontWeight = FontWeight.Bold)) {
                            append("Description : ")
                        }
                        append(jobPost.description)
                    },
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp,
                    )
                )
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = darkBlue, fontWeight = FontWeight.Bold)) {
                            append("Experience : ")
                        }
                        append(jobPost.experiance.toString())
                    },
                    style = TextStyle(
                        color = Color.Gray,
                        fontSize = 15.sp
                    )
                )
                OrderedList(
                    title = "Skills",
                    items = jobPost.techstack,
                    textColor = darkBlue
                )

            }
        }

    }
}
@Composable
fun OrderedList(
    title: String,
    items: List<String>,
    textColor: Color
) {
    Column() {
        Text(
            modifier = Modifier.padding(end = 8.dp),
            text = title,
            color = textColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Bold
        )
        items.forEachIndexed { index, item ->
            Text(
                modifier = Modifier
                    .fillMaxHeight()
                    .alpha(ContentAlpha.medium)
                    .padding(end = 2.dp),
                text = "${index + 1}. $item",
                color = Color.DarkGray,
                fontSize = MaterialTheme.typography.body1.fontSize
            )
        }
    }
}


