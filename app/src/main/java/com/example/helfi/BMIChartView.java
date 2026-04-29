package com.example.helfi;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class BMIChartView extends View {
    private final Paint axisPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint linePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint pointPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private final Paint labelPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private List<Float> values = new ArrayList<>();

    public BMIChartView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        axisPaint.setColor(Color.DKGRAY);
        axisPaint.setStrokeWidth(3);

        linePaint.setColor(Color.WHITE);
        linePaint.setStrokeWidth(6);
        linePaint.setStyle(Paint.Style.STROKE);

        pointPaint.setColor(Color.WHITE);
        pointPaint.setStyle(Paint.Style.FILL);

        labelPaint.setColor(Color.DKGRAY);
        labelPaint.setTextSize(32f);
    }

    public void setValues(List<Float> values) {
        this.values = values == null ? new ArrayList<>() : new ArrayList<>(values);
        invalidate();
    }

    @SuppressLint("DefaultLocale")
    @Override
    protected void onDraw(@NonNull Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = 50;
        int paddingBottom = 60;
        int paddingTop = 30;
        int paddingRight = 30;

        canvas.drawLine(paddingLeft, paddingTop, paddingLeft, height - paddingBottom, axisPaint);
        canvas.drawLine(paddingLeft, height - paddingBottom, width - paddingRight, height - paddingBottom, axisPaint);

        if (values.isEmpty()) {
            labelPaint.setTextSize(28f);
            canvas.drawText("Brak danych do wykresu", paddingLeft + 20, height / 2f, labelPaint);
            return;
        }

        float max = values.stream().max(Float::compareTo).orElse(1f);
        float min = values.stream().min(Float::compareTo).orElse(1f);
        float range = Math.max(1f, max - min);

        int count = values.size();
        float stepX = (width - paddingLeft - paddingRight) / (float) Math.max(1, count - 1);
        @SuppressLint("DrawAllocation") Path path = new Path();

        for (int i = 0; i < count; i++) {
            float value = values.get(i);
            float x = paddingLeft + i * stepX;
            float y = paddingTop + (max - value) / range * (height - paddingTop - paddingBottom);
            if (i == 0) path.moveTo(x, y);
            else path.lineTo(x, y);
            canvas.drawCircle(x, y, 8f, pointPaint);
            canvas.drawText(String.format("%.1f", value), x - 24, y - 14, labelPaint);
            canvas.drawText("T" + (i + 1), x - 14, height - paddingBottom + 30, labelPaint);
        }

        canvas.drawPath(path, linePaint);
    }
}
