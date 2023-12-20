/**
 * 
 */
package com.other.algorithms;

/**
 * @author sjonnalagadda
 *
 */
public class FileUploadTOServer
{
	/*private static final Logger LOG = Logger.getLogger(FileUploadTOServer.class.getSimpleName());
	
	private Session session = null;
	private Channel channel = null;
	private ChannelSftp channelSftp = null;
	
	private String SID = "111";
	private String TID = "112";
	private String CID = "113";
	private String SFTPWORKINGDIR = "/home/sjonnalagadda/Desktop/Ajay/";

	private Timer TIMER = null;
	private String FILENAME = null;
	
	public FileUploadTOServer(String fileName, Timer timer){
		this.TIMER = timer;
		this.FILENAME = fileName;
	}
	
	*//**
	 * @param args
	 *//*
	public static void main(String[] args)
	{
		Timer timer = new Timer();
		FileUploadTOServer handler = new FileUploadTOServer("" + ".gz", timer);
		long delay = (long) (Math.random()*100) % 60;
		delay = delay<5?5:delay;
		//delay = 1;
		handler.showDelay(delay);
		timer.schedule(new TimerTask()
		{
			@Override
			public void run()
			{
			}
		}, delay*60*1000);
	}
	
	protected void showDelay(long delay){
		LOG.info("Generated Delay for logs upload ::"+delay);
	}
	
	private void compressGzipFile(String file, String gzipFile) {
		try {
			FileInputStream fis = new FileInputStream(file);
			FileOutputStream fos = new FileOutputStream(gzipFile);
			GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
			byte[] buffer = new byte[1024];
			int len;
			while((len=fis.read(buffer)) != -1){
				gzipOS.write(buffer, 0, len);
			}
			//close resources
			gzipOS.finish();
			gzipOS.close();
			fos.close();
			fis.close();

			File fl = new File(file);
			fl.delete();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	private boolean transferFile(String fileName){
		boolean isFileTransfered = false;

		try {
			JSch jsch = new JSch();
			//session = jsch.getSession(SFTPUSER, SFTPHOST, SFTPPORT);
			//session.setPassword(SFTPPASS);
			session = jsch.getSession("sjonnalagadda", "**.**.**.**", 22);
			session.setPassword("***************");
			java.util.Properties config = new java.util.Properties();
			config.put("StrictHostKeyChecking", "no");
			session.setConfig(config);
			session.connect();
			LOG.info("Host connected.");

			channel = session.openChannel("sftp");
			channel.connect();
			LOG.info("sftp channel opened and connected.");

			channelSftp = (ChannelSftp) channel;

			try {
				channelSftp.cd(SFTPWORKINGDIR + CID);
			} catch (Exception e) {
				channelSftp.mkdir(SFTPWORKINGDIR + CID);
				channelSftp.cd(SFTPWORKINGDIR + CID);
			}

			try {
				channelSftp.cd(SFTPWORKINGDIR + CID + "/" + SID);
			} catch (Exception e) {
				channelSftp.mkdir(SFTPWORKINGDIR + CID + "/" + SID);
				channelSftp.cd(SFTPWORKINGDIR + CID + "/" + SID);
			}

			try {
				channelSftp.cd(SFTPWORKINGDIR + CID + "/" + SID + "/" + TID);
			} catch (Exception e) {
				channelSftp.mkdir(SFTPWORKINGDIR + CID + "/" + SID + "/" + TID);
				channelSftp.cd(SFTPWORKINGDIR + CID + "/" + SID + "/" + TID);
			}

			File f = new File(fileName);
			// fileName

			FileInputStream fis = new FileInputStream(f); 
			channelSftp.put(fis, f.getName());
			isFileTransfered = true;

			try {
				if(session!=null){
					session.disconnect();
				}

				if(channelSftp!=null){
					channelSftp.exit();
				}

				if(channel!=null){
					channel.disconnect();
				}
				if(fis!=null){
					fis.close();
				}
			} catch (Exception e) {}

			//Renaming again after successful transfer
			File file1 = new File(fileName);		
			fileName = fileName.replace("_", "");
			File file2 = new File(fileName);		
			file1.renameTo(file2);

			LOG.info("File transfered successfully to host: " + fileName);
		} catch (Exception ex) {
			LOG.error("Exception found while tranfer the response ::"+ex.getMessage());
		}
		finally{
			try {
				if(session!=null){
					session.disconnect();
				}

				if(channelSftp!=null){
					channelSftp.exit();
				}

				if(channel!=null){
					channel.disconnect();
				}
			} catch (Exception e) {}
		}

		return isFileTransfered;
	}*/
}
