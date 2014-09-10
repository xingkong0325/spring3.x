package com.donnglin.concurrent.thread;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Renderer {
	
	private final ExecutorService executor;

    Renderer(ExecutorService executor) {
        this.executor = executor;
    }
    
    void renderPage(CharSequence source){
    	 final List<ImageInfo> info = scanForImageInfo(source);
    	 CompletionService<ImageData> complitionService = new ExecutorCompletionService<ImageData>(executor);
    	 for(final ImageInfo imageInfo: info){
    		 complitionService.submit(new Callable<ImageData>(){
				public ImageData call() throws Exception {
					return imageInfo.downloadImage();
				}
    		 });
    	 }
    	 renderText(source);
    	 
    	 try {
			for(int t=0; t<info.size(); t++){
				 Future<ImageData> f = complitionService.take();
				 ImageData data;
				 data = f.get();
				 renderImage(data);
			 }
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
    	 
    }
	
    interface ImageData {
    }

    interface ImageInfo {
        ImageData downloadImage();
    }

    void renderText(CharSequence s){}

    List<ImageInfo> scanForImageInfo(CharSequence s){return null;}

    void renderImage(ImageData i){}

}
