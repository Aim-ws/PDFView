package com.example.pdfview;

import com.joanzapata.pdf.PDFView;
import com.joanzapata.pdf.listener.OnPageChangeListener;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements OnPageChangeListener{
	public static final String SAMPLE_FILE = "sample.pdf";

    public static final String ABOUT_FILE = "about.pdf";
    
    String pdfName = SAMPLE_FILE;
    Integer pageNumber = 1;
	
	private PDFView mPdfView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mPdfView = (PDFView) findViewById(R.id.id_pdfView);
		setTitle(pdfName);

        mPdfView.fromAsset(pdfName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .load();
	}

	@Override
	public void onPageChanged(int page, int pageCount) {
		// TODO Auto-generated method stub
		pageNumber = page;
        setTitle(String.format("%s %s / %s", pdfName, page, pageCount));
	}
	
	
	private void display(String assetFileName, boolean jumpToFirstPage) {
        if (jumpToFirstPage) pageNumber = 1;
        setTitle(pdfName = assetFileName);

        mPdfView.fromAsset(assetFileName)
                .defaultPage(pageNumber)
                .onPageChange(this)
                .load();
    }
	
	private boolean displaying(String fileName) {
        return fileName.equals(pdfName);
    }

	
}
