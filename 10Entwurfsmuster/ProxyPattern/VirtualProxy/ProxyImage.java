package virtualProxy;


public class ProxyImage {
private Image image;
private String url;
private int sizeX;
private int sizeY;

public ProxyImage(String url, int sizeX, int sizeY){
	this.image = new Image();
	this.url = url;
	this.sizeX = sizeX;
	this.sizeY = sizeY;
	startAsyncImageLoadingInThread();
}
void startAsyncImageLoadingInThread(){
	image.loadImageFromUrl(url);
}
void showImage(){
	if(image.getIsLoaded()){
		//Echtes Bild
		canvas.drawImage(image.getImageData());
	}else{
		//Rechteck als Stellvertreter
		canvas.drawRectangle(sizeX,sizeY);
	}
}
}
