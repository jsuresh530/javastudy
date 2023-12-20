

package com.coreexamples.CoreJava;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.StringUtils;


public class BMPFileFromText
{

	private static final int	WIDTH		= 10;
	private static final int	HEIGHT		= 10;
	static String				HEX_STRING	= "0123456789ABCDEF";

	public static byte[] convertHexadecimal2Binary(byte[] hex)
	{
		int block = 0;
		byte[] data = new byte[hex.length / 2];
		int index = 0;
		boolean next = false;
		for (int i = 0; i < hex.length; i++)
		{
			block <<= 4;
			int pos = HEX_STRING.indexOf(Character.toUpperCase((char) hex[i]));
			if (pos > -1)
			{
				block += pos;
			}
			if (next)
			{
				data[index] = (byte) (block & 0xff);
				index++;
				next = false;
			}
			else
			{
				next = true;
			}
		}
		return data;
	}

	public static void resize(String inputImagePath, String outputImagePath, double percent) throws IOException
	{
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		int scaledWidth = (int) (inputImage.getWidth() * percent);
		int scaledHeight = (int) (inputImage.getHeight() * percent);
		resize(inputImagePath, outputImagePath, scaledWidth, scaledHeight);
	}

	public static void resize(String inputImagePath, String outputImagePath, int scaledWidth, int scaledHeight) throws IOException
	{
		// reads input image
		File inputFile = new File(inputImagePath);
		BufferedImage inputImage = ImageIO.read(inputFile);
		// creates output image
		BufferedImage outputImage = new BufferedImage(scaledWidth, scaledHeight, inputImage.getType());
		// scales the input image to the output image
		Graphics2D g2d = outputImage.createGraphics();
		g2d.drawImage(inputImage, 0, 0, scaledWidth, scaledHeight, null);
		g2d.dispose();
		// extracts extension of output file
		String formatName = outputImagePath.substring(outputImagePath.lastIndexOf(".") + 1);
		// writes to output file
		ImageIO.write(outputImage, formatName, new File(outputImagePath));
	}

	private static BufferedImage resize(BufferedImage img, int height, int width) {
        Image tmp = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage resized = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = resized.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();
        return resized;
    }
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	        data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	                + Character.digit(s.charAt(i + 1), 16));
	        System.out.print(data[i / 2] & 0xFF);
	        System.out.print(" ");
	    }
	    return data;
	}
	
	public static void main(String args[])
	{
		//This is the sample signature text, received from cct signatature data.
		System.out.println("------------- BMP file coversion started ------------- ");
		//String src1 = "3035392c3039312c305e3036302c3039302c305e3036342c3038382c305e3037312c3038342c305e3037382c3038302c305e3038302c3037392c305e3038312c3037382c305e3038312c3037382c305e3037392c3038302c305e3037362c3038322c305e3037362c3038342c305e3037382c3038342c305e3038372c3038342c305e3039382c3038322c305e3130362c3038312c305e3131302c3038322c305e3131322c3038342c305e3131322c3038362c305e3131342c3038392c305e3131372c3039312c305e3132352c3039312c305e3133382c3038392c305e3134372c3038372c305e3135332c3038372c305e3135352c3038372c305e3135372c3038392c305e3135382c3039312c305e3136302c3039332c305e3136352c3039332c305e3137322c3039322c305e3138312c3038392c305e3138372c3038362c305e3139312c3038352c305e3139322c3038352c305e3139322c3038352c305e3139322c3038362c305e3139322c3038362c315e3033362c3039332c305e3033352c3039332c305e3033352c3039322c305e3033352c3039322c305e3033352c3039322c305e3033352c3039322c305e3033382c3039332c305e3034332c3039342c305e3034372c3039342c305e3035332c3039312c305e3035372c3038372c305e3036302c3038332c305e3036322c3037382c305e3036332c3037342c305e3036312c3036392c305e3035362c3036362c305e3035322c3036372c305e3034382c3036392c305e3034342c3037322c305e3034322c3037352c305e3034322c3037372c305e3034342c3038302c305e3035302c3038322c305e3036312c3038332c305e3036392c3038332c305e3037362c3038342c305e3038302c3038362c305e3038332c3038372c305e3038332c3038392c305e3038322c3039322c305e3037382c3039352c305e3037362c3039362c305e3037352c3039362c305e3037342c3039352c305e3037352c3039322c305e3037392c3038372c305e3038332c3038332c305e3038382c3038312c305e3039332c3038332c305e3039372c3038372c305e3130312c3039342c305e3130352c3039382c305e3130392c3039392c305e3131342c3039352c305e3131392c3038382c305e3132342c3038322c305e3132372c3038302c305e3132392c3037392c305e3133312c3038302c305e3133342c3038322c305e3133382c3038322c305e3134312c3038322c305e3134342c3038322c305e3134372c3038322c305e3134392c3038332c305e3135342c3038372c305e3135352c3038382c305e3135352c3038382c315e";
		
		String src1 = "025330324E3131383256464953494730300125FFFFFFFFEC019C02EA019B02E8019B02E6019B02E3019C02DF019E02D901A202D301A602CC01AD02C501B502BD01BE02B101CC02A501DC029901EE028D010203840116037D0129037A013B037B014C0380015B038801670394017003A2017803B2017D03C2018003D3018203E1018403ED018803F6018D03F9019403F8019C03F301A503EA01AE03DE01B703D001C003C201C703B501CB03FFFFFFFF06024403050244030502430305024303040243030402430304024403050245030602480307024B03090250030D02560312025D03180265031F026D03260275032E027C03370281033F028303460283034D02800353027A03580272035B0267035D025C035D0250035D0244035C023A035C0232035B022E035B022C035D022E036002340364023D036A024703720252037B025D03840268038F02700399027603A2027A03AB027C03B3027A03BA027703BF027103C3026903C5026103C6025803C7025103C7024A03C7024503C8024303CA024303CE024403D2024803D8024E03DE025403E5025B03EC026203F3026803F9026C03FF026F0304036E0309036B030C0365030E035D030F035303100348030F033B030F032F030E0323030C0318030B030E030A0306030A0301030A03FE020B03FE020E03FF0212030203170306031E030A0326030E032E0311033703140340031503480314034F03120356030D035C0307036003FF026203F6026303ED026303E4026303DC026103D5026003D1026003D0026003D2026203D7026403DF026803EA026C03F60271030403760311037C031D038103270386032F038A0333038E0334039103310393032B039403240395031B039603120396030903970302039903FE02FFFFFFFF4B0464034A0464034A0465034A0466034A0468034A0469034B046B034B046D034B046D034A046D0348046D0344046A034004650339045E03320455032904490320043B0316042B030D041A0304040803FC03F502F603E202F203D002F003C002F103B202F403A802FA03A10200049D0208049D020F049F021604A4021D04AC022204B6022704C2022B04D0022E04DF023204EE023704FD023C040B03420419034904250350042F0359043903610441036A04490371045103760459037804620377046C03720476036B04800362048903570491034C04980341049D0337049F0331049E032D049A032D0493033104880338047B0343046C0351045B0360044B036F043B037F042D038D04200399041503A4040D03AD040603B3040203B7040003B904FF02BA040003BB040303BA040703BA040B03BB040F03BC041203BE041403C0041503C4041403C7041203CB041003CF040C03D3040903D6040403DA040003DD04FB02DF04F802E104F602E304F502E404F602E604F702E704F902E904F902EA04F802ED04F502EF04F102F104EA02F404E202F604D802F804CE02FA04C402FB04BA02FD04B102FF04AA020105A7020505A6020A05AA021105B0021805BA022105C6022A05D3023405E1023D05F002450500034B050F034F051D0351052A03500536034E053F034A054403460546034305440343053E03450535034B05270355051703FFFFFFFF9805D7049905D8049A05D9049B05DC049C05DF04FFFFFFFF037A";
		String line = "";
		// String line_final = "";
		try
		{
			//String sCurrentLine;
			//BufferedReader br = new BufferedReader(new FileReader("src/signature.txt"));// test.txt
																						// hex code
			//			System.err.println("src "+src.length()+" "+src1.length());																// string
			DataOutputStream os = new DataOutputStream(new FileOutputStream("D:\\image.png"));
			/*while ((sCurrentLine = br.readLine()) != null)
			{
				line = StringUtils.deleteWhitespace(sCurrentLine);
				byte[] temp = convertHexadecimal2Binary(line.getBytes());
				os.write(temp);
			}*/
			line = StringUtils.deleteWhitespace(src1);
			byte[] temp = convertHexadecimal2Binary(line.getBytes());
			os.write(temp);
			System.out.println("------------- BMP file created ------------- ");
			os.close();
	        
	        
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
/*		try{

			byte[] rawBytes =hexStringToByteArray(src) ;
			int width = 300;
			int height = 300;
			File outputFile = new File("/home/sjonnalagadda/AESDK/test.jpg");
			
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            int count = 0; 
            for(int h=0;h<height;h++){
                for(int w=0;w<width;w++){
                    bi.setRGB(w, h, rawBytes[count++]);
                }
            }
            
            for(int w = 0; w < width; w++)
            {
                for(int h = 0; h < height; h++)
                {
                        //alpha should be eiter 0 or 255
                        //if you use the wrong value your image will be transparent

                        int alpha = 0 << 8*3;
                        int red = rawBytes[count*3 + 0] << 8*2;
                        int green = rawBytes[count*3 + 1] << 8*1;
                        int blue = rawBytes[count*3 + 2] << 8*0;

                        int color = alpha + red + green + blue;

                        //color is an int with the format of TYPE_INT_ARGB (0xAARRGGBB)

                        bi.setRGB(w, h, color);
                        count += 3;
                }
            }
            Graphics2D ig2 = bi.createGraphics();

            Iterator imageWriters = ImageIO.getImageWritersByFormatName("jpeg");
            ImageWriter imageWriter = (ImageWriter) imageWriters.next(); 

            ImageOutputStream ios = ImageIO.createImageOutputStream(outputFile);
            imageWriter.setOutput(ios);
            imageWriter.write(bi);


        }catch(Exception ex){
            ex.printStackTrace();
        }*/

		
	}
}