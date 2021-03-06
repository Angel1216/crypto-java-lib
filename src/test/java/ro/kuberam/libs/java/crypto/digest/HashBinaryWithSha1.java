package ro.kuberam.libs.java.crypto.digest;

import java.io.InputStream;

import org.junit.Assert;
import org.junit.Test;

import ro.kuberam.libs.java.crypto.digest.Hash;
import ro.kuberam.tests.junit.BaseTest;

public class HashBinaryWithSha1 extends BaseTest {

	@Test
	public void hashBinaryWithSha1() throws Exception {
		InputStream input = getClass().getResourceAsStream("../keystore.ks");
		String result = Hash.hashBinary(input, "SHA-1", "base64");

		Assert.assertTrue(result.equals("GyscHvnJKxInsBLgSg/FRAmQXYU="));
	}
}
