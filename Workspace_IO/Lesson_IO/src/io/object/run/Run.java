package io.object.run;

import io.object.model.dao.ObjectIoTest;

public class Run {

	public static void main(String[] args) {
//		new ObjectIoTest().fileSave();
//		new ObjectIoTest().fileRead();
		new ObjectIoTest().fileSaveList();
		new ObjectIoTest().fileReadList();
	}
}
