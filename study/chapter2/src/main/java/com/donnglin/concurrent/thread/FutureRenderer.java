package com.donnglin.concurrent.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureRenderer {
	
	private final ExecutorService executor = Executors.newCachedThreadPool();
	
	void renderPage(CharSequence source){
		final List<ImageInfo> imageInfos = scanForImageInfo(source);
		Callable<List<ImageData>> task = new Callable<List<ImageData>>(){
			public List<ImageData> call() throws Exception {
				List<ImageData> result = new ArrayList<ImageData>();
				for(ImageInfo imageInfo: imageInfos){
					result.add(imageInfo.downloadImage());
				}
				return result;
			}	
		};
		Future<List<ImageData>> future = executor.submit(task);
		renderText(source);
		try {
			List<ImageData> imageDatas = future.get();
			for(ImageData data: imageDatas)
				renderImage(data);
		} catch (InterruptedException e) {
			//重新设置线程的终止状态
			Thread.currentThread().interrupt();
			//由于不需要结果，因此取消任务
			future.cancel(true);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	private void renderImage(ImageData data) {}

	private void renderText(CharSequence source) {}

	private List<ImageInfo> scanForImageInfo(CharSequence source) {
		return null;
	}

	interface ImageInfo {
		public ImageData downloadImage();
	}

	interface ImageData{}
}
