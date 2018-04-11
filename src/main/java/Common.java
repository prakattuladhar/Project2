import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public final class Common {
	private int[] info;
	public Common() throws IOException {
		fileImport();
	}
	public int getFridgeLow(){
		return info[0];
	}
	public int getFridgeHigh() {
		return info[1];
	}
	public int getFreezerLow() {
		return info[2];
	}
	public int getFreezerHigh() {
		return info[3];
	}
	public int getRoomLow() {
		return info[4];
	}
	public int getRoomHigh() {
		return info[5];
	}
	public int getFridgeRateLossDoorClosed() {
		return info[6];
	}
	public int getFridgeRateLossDoorOpen() {
		return info[7];
	}
	public int getFreezerRateLossDoorClosed() {
		return info[8];
	}
	public int getFreezerRateLossDoorOpen() {
		return info[9];
	}
	public int getFridgeCompressorStartDiff() {
		return info[10];
	}
	public int getFreezerCompressorStartDiff() {
		return info[11];
	}
	public int getFridgeCoolRate() {
		return info[12];
	}
	public int getFreezerCoolRate() {
		return info[13];
	}
	private void fileImport() throws IOException {
		int input[] = new int[14];
		String line;
		try {
			FileReader fr = new FileReader("config.ini");
			BufferedReader br = new BufferedReader(fr); 
			while((line=br.readLine())!=null) {
				int temp;
				int i;
				for(i=0; line.charAt(i)!='='; i++) {
				}
				temp = whatInput(line.substring(0, i));
				if(temp!=-1)
					input[temp] =  Integer.parseInt(line.substring(i+1));
			}
			br.close();
			fr.close();
			info = input;
		}
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file");                
        }
		catch(IOException ex) {
			System.out.println("IOException");
		}
	}
	private int whatInput(String test) {
		int end;
		switch(test) {
		case "FridgeLow":
			end = 0;
			break;
		case "FridgeHigh":
			end = 1;
			break;
		case "FreezerLow":
			end = 2;
			break;
		case "FreezerHigh":
			end = 3;
			break;
		case "RoomLow":
			end = 4;
			break;
		case "RoomHigh":
			end = 5;
			break;
		case "FridgeRateLossDoorClosed":
			end = 6;
			break;
		case "FridgeRateLossDoorOpen":
			end = 7;
			break;
		case "FreezerRateLossDoorClosed":
			end = 8;
			break;
		case "FreezerRateLossDoorOpen":
			end = 9;
			break;
		case "FridgeCompressorStartDiff":
			end = 10;
			break;
		case "FreezerCompressorStartDiff":
			end = 11;
			break;
		case "FridgeCoolRate":
			end = 12;
			break;
		case "FreezerCoolRate":
			end = 13;
			break;
		default:
			end = -1;	
			break;
		}
		return end;
	}
}
