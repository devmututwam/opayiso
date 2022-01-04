package zm.co.opayiso8583;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.jpos.iso.ISOException;
import org.jpos.iso.ISOMsg;


public class MyUtils {

	static int offset;
	public static String drcr_ind;

	public static void getISOFiled(ISOMsg msg) {
		String trans_response = "";
		System.out.println("----ISO MESSAGE-----");
		try {
			System.out.println("  MTI : " + msg.getMTI());
			for (int i = 1; i <= msg.getMaxField(); i++) {
				if (msg.hasField(i)) {
					System.out.println("    Field-" + i + " : " + msg.getString(i));
					String val = msg.getString(i);

					if (i == 39) {
						if (val.equals("00")) {
							System.out.println("Transaction successful");
							trans_response = "Transaction successful";
						} else if (val.equals("12")) {
							System.out.println("Invalid transaction");
							trans_response = "Invalid transaction";
						} else if (val.equals("13")) {
							System.out.println("Invalid amount");
							trans_response = "Invalid amount";
						} else if (val.equals("39")) {
							System.out.println("No credit account");
							trans_response = "No credit account";
						} else if (val.equals("51")) {
							System.out.println("Insufficient Funds");
							trans_response = "Insufficient Funds";
						} else if (val.equals("91")) {
							System.out.println("Issuer or switch inoperative");
							trans_response = "Issuer or switch inoperative";
						} else if (val.equals("96")) {
							System.out.println("System mulfunction");
							trans_response = "System mulfunction";
						} else if (val.equals("98")) {
							System.out.println("Exceeds cash limit");
							trans_response = "Exceeds cash limit";
						} else if (val.equals("42")) {
							System.out.println("No universal account");
							trans_response = "No universal account";
						} else {

							System.out.println("Transaction failed");
							System.out.println(msg.getString(i));
						}
					}

					if (i == 54) {
						String ac_type = val.substring(0, 2);
						System.out.println("Account type is " + ac_type);
						String amount_type = val.substring(2, 4);
						System.out.println("Amount type is " + amount_type);
						String ccy_code = val.substring(4, 7);
						System.out.println("Currency code is " + ccy_code);
						drcr_ind = val.substring(7, 8);
						System.out.println("DRCR Indicator     " + drcr_ind);
						Integer ledg_bal_from = Integer.valueOf(Integer.parseInt(val.substring(8, 20)));
						System.out.println("Ledger balance from account " + ledg_bal_from);

					}

				}

			}

		} catch (ISOException e) {
			e.printStackTrace();
		} finally {
			System.out.println("--------------------");
		}
	}

	public static String getFieldLengths(String f127_22) {
		int lengthOfLength = Integer.toString(f127_22.length()).length();
		int lengthOf = f127_22.length();
		String value = lengthOfLength + "" + lengthOf + "" + f127_22;

		System.out.println("tag :" + value);

		return value;
	}

	public static String iso_response_code(String code) {
		String trn_response = "";

		if (code.equals("00")) {

			trn_response = "Transaction successful";
		} else if (code.equals("12")) {

			trn_response = "Transaction failed : Invalid transaction";
		} else if (code.equals("13")) {

			trn_response = "Transaction failed : Invalid amount";
		} else if (code.equals("39")) {

			trn_response = "Transaction failed : No credit account";
		} else if (code.equals("51")) {

			trn_response = "Transaction failed : Insufficient Funds";
		} else if (code.equals("91")) {

			trn_response = "Transaction failed : Issuer or switch inoperative";
		} else if (code.equals("96")) {

			trn_response = "Transaction failed : System mulfunction";
		} else if (code.equals("98")) {

			trn_response = "Transaction failed : Exceeds cash limit";
		} else if (code.equals("42")) {

			trn_response = "Transaction failed : No universal account";
		} else {

			trn_response = "Transaction failed : Transaction failed";
		}

		return trn_response;
	}

	private static String getData(String f127_22, int size) {
		return f127_22.substring(offset, offset += size);
	}
}
