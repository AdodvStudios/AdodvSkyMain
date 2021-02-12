package plugin.adodvstudios.skyblock.utils;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class DownloadSchematics {
	
	public static void Download() throws IOException {
		String urlStr = "http://adodvstudios.webtm.ru/files/default.schematic";
		String file = "plugins/AdodvSkyBlock/default.schematic";
		
        URL url = new URL(urlStr);
        ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        FileOutputStream fos = new FileOutputStream(file);
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        fos.close();
        rbc.close();
    }

}
