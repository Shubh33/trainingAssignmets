
package com.vogella.emf.webpage.usingmodel;

import com.vogella.emf.webpage.model.webpage.Web;
import com.vogella.emf.webpage.model.webpage.Webpage;
import com.vogella.emf.webpage.model.webpage.WebpageFactory;

public class UsingEMFModel {
	public static void main(String[] args) {
//        WebpagePackage.eINSTANCE;
		// Retrieve the default factory singleton
		WebpageFactory factory = WebpageFactory.eINSTANCE;
		// create an instance of myWeb
		Web myWeb = factory.createWeb();
		myWeb.setName("Hallo");
		myWeb.setDescription("This is a description");
		// create a page
		Webpage webpage = factory.createWebpage();
		webpage.setTitle("This is a title");
		// add the page to myWeb
		((Webpage) myWeb.getPages()).add(webpage);
		// and so on, and so on
		// as you can see the EMF model can be (more or less) used as standard Java
	}
}