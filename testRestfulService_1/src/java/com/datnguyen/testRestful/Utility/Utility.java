/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.datnguyen.testRestful.Utility;

public class Utility {
    private static String zoom;
    private static int zoomInt;
    private static String size;
    private static String mapType;
    private static String sensor;
    private static boolean marker;
    
    public static String getHttpLocationFromLatLong(Double lat, Double lng){
		String httpLocation;
                httpLocation ="http://maps.googleapis.com/maps/api/staticmap?center=";
		zoom="&zoom=16";
		zoomInt=16;
		size="&size=600x300";
		mapType="&maptype=roadmap";
		sensor="&sensor=false";
                httpLocation = ""+ httpLocation + lat+","+lng+zoom+size+mapType+"&markers=color:green%7Clabel:G%7C"+lat+","+lng+sensor;
		//return httpLocation+"&key=AIzaSyDMLevZctGVGDrupSRW09f131Ps2gebY9A";
                return httpLocation;
	}
}
