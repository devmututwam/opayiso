package zm.co.opayiso8583;

import org.jpos.iso.BaseChannel;
import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;
import org.jpos.iso.ISOPackager;
import org.jpos.iso.channel.PostChannel;
import org.jpos.iso.packager.GenericPackager;
import org.jpos.util.LogListener;
import org.jpos.util.LogSource;
import org.jpos.util.Logger;
import org.jpos.util.SimpleLogListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ReceiverScheduler {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:sss");
	@Scheduled(fixedDelay = 5000)
	public void signOn() {


		
		ISOMsg iso_result = new ISOMsg();
		/*try {
			Logger logger = new Logger();
			logger.addListener((LogListener) new SimpleLogListener(System.out));
			GenericPackager packager = new GenericPackager("C:/xmliso/xml_res/opay.xml");
			PostChannel postChannel = new PostChannel("47.57.18.189", 5026, (ISOPackager) packager);
			BaseChannel getChannel = new BaseChannel() {
				@Override
				public void setHost(String host, int port) {
					super.setHost("47.57.18.189", 5026);
				}
			};

			try {
				getChannel.setTimeout(30000);
			} catch (SocketException e) {
				e.printStackTrace();
			}

			((LogSource) getChannel).setLogger(logger, "test-channel");
			getChannel.connect();

			ISOMsg m = new ISOMsg();
		*//*	m.setMTI("1804");
			m.set(7, "85720");
			m.set(11, ("644119"));
			m.set(28, (new java.text.SimpleDateFormat("yyMMdd")).format(new Date()));*//*
			//m.getMTI();
			m.getString(7);
			m.getString(11);
			m.getString(28);

			//m.set(93, ("1000000000"));
			m.getString(93);
			m.getString(94);
			getChannel.accept(getChannel.getServerSocket());
			getChannel.connect();

			iso_result = getChannel.receive();
 
			MyUtils.getISOFiled(iso_result);
			postChannel.disconnect();
		} catch (ISOException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		String val = iso_result.getString(39);
		System.out.println("The response code is ---> " + val);*/
	}


}
