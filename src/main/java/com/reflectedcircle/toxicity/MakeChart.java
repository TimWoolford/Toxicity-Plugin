package com.reflectedcircle.toxicity;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.jfree.chart.ChartFactory.createStackedBarChart;
import static org.jfree.chart.ChartUtilities.saveChartAsPNG;

public class MakeChart {

    public void checkThatStyle(String rootPath, String outputPath) throws Exception {
        checkThatStyle(files(new File(rootPath)), outputPath);
    }

    private void checkThatStyle(List<File> files, String outputPath) throws Exception {
        DataRegister<ToxicEntity> register = new DataRegister<ToxicEntity>();

        ToxicityChecker checker = new ToxicityChecker(register);

        checker.process(files);

        JFreeChart chart = buildChart(register.getDataSet());

        saveChartAsPNG(new File(outputPath), chart, 900, 900);
    }


    private JFreeChart buildChart(CategoryDataset dataSet) {
        JFreeChart chart = createStackedBarChart("Title", "Class", "Toxicity", dataSet, PlotOrientation.VERTICAL, true, true, false);
        CategoryAxis domainAxis = chart.getCategoryPlot().getDomainAxis();
        domainAxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        domainAxis.setMaximumCategoryLabelWidthRatio(1.0f);
        domainAxis.setMaximumCategoryLabelLines(5);

        ValueAxis rangeAxis = chart.getCategoryPlot().getRangeAxis();
        rangeAxis.setAutoRange(false);
        return chart;
    }

    private List<File> files(File source) {
        ArrayList<File> files = new ArrayList<File>();
        for (File file : source.listFiles()) {
            if (file.isDirectory()) {
                files.addAll(files(file));
            } else {
                files.add(file);
            }
        }
        return files;
    }
}