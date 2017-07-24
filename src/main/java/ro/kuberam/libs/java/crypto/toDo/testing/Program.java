package ro.kuberam.libs.java.crypto.toDo.testing;

public class Program
{
	static void main(String[] args)
	{

		String str1;
		String str2 = "s3gur1d@dbuf3t3d3@s3s0r3s3ns1st3m@s";
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] bytes1 = Encoding.Unicode.GetBytes("Hola Mundo");
		byte[] bytes1 = ("Hola Mundo").getBytes(java.nio.charset.StandardCharsets.UTF_16LE);
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] bytes2 = Encoding.ASCII.GetBytes(str2);
		byte[] bytes2 = str2.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
		Rfc2898DeriveBytes rfc2898DeriveBytes = new Rfc2898DeriveBytes(str2, bytes2);
		ICryptoTransform encryptor = (new RijndaelManaged()).CreateEncryptor(rfc2898DeriveBytes.GetBytes(32), rfc2898DeriveBytes.GetBytes(16));
		java.io.ByteArrayOutputStream memoryStream = new java.io.ByteArrayOutputStream();
//C# TO JAVA CONVERTER TODO TASK: C# to Java Converter cannot determine whether this System.IO.Stream is input or output:
		CryptoStream cryptoStream = new CryptoStream((Stream)memoryStream, encryptor, CryptoStreamMode.Write);
		cryptoStream.Write(bytes1, 0, bytes1.length);
		cryptoStream.FlushFinalBlock();
//C# TO JAVA CONVERTER WARNING: Unsigned integer types have no direct equivalent in Java:
//ORIGINAL LINE: byte[] inArray = memoryStream.ToArray();
		byte[] inArray = memoryStream.ToArray();
		memoryStream.close();
		cryptoStream.Close();
		str1 = Convert.ToBase64String(inArray);

		do
		{
			System.out.println("Hola Mundo!!");
			System.out.println("str1: " + str1);
		} while (Console.ReadKey().Key != ConsoleKey.Q);
	}
}