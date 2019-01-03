package dut.myshop.utils;

import java.util.UUID;

public class ActiveCodeUtils {
public static String createActiveCode() {
	return UUID.randomUUID().toString();
}
}
