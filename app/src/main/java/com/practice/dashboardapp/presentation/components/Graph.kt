package com.practice.dashboardapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import co.yml.charts.axis.AxisData
import co.yml.charts.common.model.Point
import co.yml.charts.ui.linechart.LineChart
import co.yml.charts.ui.linechart.model.GridLines
import co.yml.charts.ui.linechart.model.IntersectionPoint
import co.yml.charts.ui.linechart.model.Line
import co.yml.charts.ui.linechart.model.LineChartData
import co.yml.charts.ui.linechart.model.LinePlotData
import co.yml.charts.ui.linechart.model.LineStyle
import co.yml.charts.ui.linechart.model.LineType
import co.yml.charts.ui.linechart.model.SelectionHighlightPoint
import co.yml.charts.ui.linechart.model.SelectionHighlightPopUp
import co.yml.charts.ui.linechart.model.ShadowUnderLine
import com.practice.dashboardapp.data.mapper.toPoints
import com.practice.dashboardapp.ui.theme.customBlue

@Composable
fun Graph(map: Map<String, Int>?) {
    val pointsData2 = map?.toPoints()
    val xSteps = map?.size ?: 5
    val ySteps = 12
    val pointsData = listOf(
        Point(0f, 40f),
        Point(1f, 90f),
        Point(2f, 0f),
        Point(3f, 60f),
        Point(4f, 10f),
    )

    val xAxisData = AxisData.Builder()
        .backgroundColor(Color.Transparent)
        .steps(xSteps)
        .axisStepSize(30.dp)
        .steps(pointsData.size - 1)
        .labelData {
            it.toString()
        }
        .labelAndAxisLinePadding(15.dp)
        .axisLineColor(Color.Black)
        .axisLabelColor(Color.Black)
        .build()

    val yAxisData = AxisData.Builder()
        .backgroundColor(Color.White)
        .steps(ySteps)
        .labelData { i ->
            val yScale = 100 / ySteps
            (i * yScale).toString()
        }
        .labelAndAxisLinePadding(20.dp)
        .axisLineColor(Color.Black)
        .axisLabelColor(Color.Black)
        .build()


    val lineChartData = LineChartData(
        linePlotData = LinePlotData(
            lines = listOf(
                Line(
                    dataPoints = pointsData2 ?: pointsData,
                    lineStyle = LineStyle(
                        color = customBlue,
                        lineType = LineType.Straight(isDotted = false),
                    ),
                    IntersectionPoint(color = customBlue),
                    selectionHighlightPoint = SelectionHighlightPoint(color = customBlue),
                    shadowUnderLine = ShadowUnderLine(
                        alpha = 0.5f,
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                customBlue.copy(alpha = 0.5f),
                                Color.Transparent
                            )
                        )
                    ),
                    SelectionHighlightPopUp()
                )
            )
        ),
        backgroundColor = Color.White,
        xAxisData = xAxisData,
        yAxisData = yAxisData,
        gridLines = GridLines(color = Color.Black),
        paddingRight = 0.dp,
        containerPaddingEnd = 6.dp

    )

    ElevatedCard(
        modifier = Modifier
            .padding(top = 16.dp)
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(
            modifier = Modifier.background(Color.White).padding(5.dp)
        ) {
            Text(text = "OverView", color = MaterialTheme.colorScheme.background)
            LineChart(
                modifier = Modifier,
                lineChartData = lineChartData
            )
        }
    }


}