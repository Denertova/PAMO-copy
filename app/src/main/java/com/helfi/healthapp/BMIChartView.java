package com.helfi.healthapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.Locale;

public class BMIChartView extends View {

    private Paint linePaint;

    private Paint textPaint;

    private Paint gridPaint;

    private Paint axisPaint;

    private Paint pointPaint;

    private float[] bmiValues = {22.5f, 23.1f, 24.8f, 24.2f, 25.5f, 26.3f, 25.9f, 27.1f};

    private String[] dates = {"01.01", "08.01", "15.01", "22.01", "29.01", "05.02", "12.02", "19.02"};

    private final int padding = 60;

    public BMIChartView(Context context) {
        super(context);
        init();
    }

    public BMIChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BMIChartView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        linePaint = new Paint();
        linePaint.setColor(Color.parseColor("#2196F3"));
        linePaint.setStrokeWidth(4);
        linePaint.setAntiAlias(true);

        textPaint = new Paint();
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(32);
        textPaint.setAntiAlias(true);

        gridPaint = new Paint();
        gridPaint.setColor(Color.parseColor("#E0E0E0"));
        gridPaint.setStrokeWidth(1);

        axisPaint = new Paint();
        axisPaint.setColor(Color.BLACK);
        axisPaint.setStrokeWidth(2);

        pointPaint = new Paint();
        pointPaint.setColor(Color.parseColor("#FF6F00"));
        pointPaint.setAntiAlias(true);
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();

        drawAxes(canvas, width, height);

        drawGrid(canvas, width, height);

        drawYAxisLabels(canvas);

        drawXAxisLabels(canvas, width, height);

        drawChart(canvas, width, height);
    }

    private void drawAxes(Canvas canvas, int width, int height) {
        canvas.drawLine(padding, height - padding, width - padding, height - padding, axisPaint);
        canvas.drawLine(padding, padding, padding, height - padding, axisPaint);
    }

    private void drawGrid(Canvas canvas, int width, int height) {
        float chartHeight = height - 2 * padding;
        float chartWidth = width - 2 * padding;

        for (int i = 0; i <= 5; i++) {
            float y = height - padding - (chartHeight / 5) * i;
            canvas.drawLine(padding, y, width - padding, y, gridPaint);
        }

        if (bmiValues.length > 0) {
            float xStep = chartWidth / (bmiValues.length - 1);
            for (int i = 0; i < bmiValues.length; i++) {
                float x = padding + xStep * i;
                canvas.drawLine(x, padding, x, height - padding, gridPaint);
            }
        }
    }

    private void drawYAxisLabels(Canvas canvas) {
        float minBMI = 20f;
        float maxBMI = 30f;
        float chartHeight = getHeight() - 2 * padding;

        for (int i = 0; i <= 5; i++) {
            float bmi = maxBMI - (maxBMI - minBMI) / 5 * i;
            float y = getHeight() - padding - (chartHeight / 5) * i;
            canvas.drawText(String.format(Locale.US, "%.0f", bmi), 10, y + 8, textPaint);
        }
    }

    private void drawXAxisLabels(Canvas canvas, int width, int height) {
        float chartWidth = width - 2 * padding;
        if (bmiValues.length > 0) {
            float xStep = chartWidth / (bmiValues.length - 1);
            for (int i = 0; i < dates.length; i++) {
                float x = padding + xStep * i;
                canvas.drawText(dates[i], x - 20, height - padding + 35, textPaint);
            }
        }
    }

    private void drawChart(Canvas canvas, int width, int height) {
        if (bmiValues.length == 0) return;

        float minBMI = 20f;
        float maxBMI = 30f;
        float chartHeight = height - 2 * padding;
        float chartWidth = width - 2 * padding;

        float[] xCoords = new float[bmiValues.length];
        float[] yCoords = new float[bmiValues.length];

        for (int i = 0; i < bmiValues.length; i++) {
            xCoords[i] = padding + (chartWidth / (bmiValues.length - 1)) * i;
            float normalized = (bmiValues[i] - minBMI) / (maxBMI - minBMI);
            yCoords[i] = height - padding - (normalized * chartHeight);
        }

        for (int i = 0; i < xCoords.length - 1; i++) {
            canvas.drawLine(xCoords[i], yCoords[i], xCoords[i + 1], yCoords[i + 1], linePaint);
        }

        for (int i = 0; i < xCoords.length; i++) {
            int pointRadius = 8;
            canvas.drawCircle(xCoords[i], yCoords[i], pointRadius, pointPaint);

            Paint valuePaint = new Paint();
            valuePaint.setColor(Color.parseColor("#FF6F00"));
            valuePaint.setTextSize(28);
            valuePaint.setAntiAlias(true);
            canvas.drawText(String.format(Locale.US, "%.1f", bmiValues[i]), xCoords[i] - 15, yCoords[i] - 15, valuePaint);
        }
    }

    @SuppressWarnings("unused")
    public void setData(float[] values, String[] dateLabels) {
        this.bmiValues = values;
        this.dates = dateLabels;
        invalidate();
    }
}
