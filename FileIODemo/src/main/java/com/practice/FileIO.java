package com.practice;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileIO {
	public static void main(String[] args) {
		// 创建目标file对象
		File target = new File("E:/test/demo.txt");
		// 创建源文件
		File source = new File("E:/test/test.txt");
		InputStream in = null;
		OutputStream out = null;
		try {
			// 判断目标文件是否存在
			if (!target.exists() || !target.isFile()) {
				boolean isSucceed = target.createNewFile();
				if (isSucceed) {
					System.out.println(target.getName() + "文件已创建!");
				}
			}
			// 如果文件不存在，则创建文件
			// 使用字节流读取文件
			in = new FileInputStream(source);
			// 使用字节流来写入文件
			out = new FileOutputStream(target);
			// 设置缓冲区大小
			byte[] b = new byte[10];
			System.out.println("正在读写文件...");
			// 至少读取一个字节，将读取的字节存储到字节数组b中，返回值为读取的字节数,
			// 如果读到输入流的尾部，则返回-1,当字节数组b大小为0时，不会有字节被读取
			// 到数组b中，返回值为0.直到读取数据是可用的，或者读到了文件的尾部，或者
			// 是发生了异常，该方法都会异常
			int length = in.read(b);
			while (length != -1) {
				// 从给定字节数组中写出数据到目标文件
				out.write(b);
				length = in.read(b);
			}
			System.out.println("读写完成!");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭输入输出流，后创建的先关闭，避免依赖关系
				out.close();
				in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
