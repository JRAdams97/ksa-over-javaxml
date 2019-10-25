package com.ksa;

import java.util.List;

public abstract class DataLoader {

	public boolean load() {
		return true;
	}

	public abstract List<String> parse();
}
