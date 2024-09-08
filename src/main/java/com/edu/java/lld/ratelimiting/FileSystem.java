package com.edu.java.lld.ratelimiting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// Abstract base class for file system entities
abstract class FileSystemEntity {
	protected String name;
	protected Directory parent;

	public FileSystemEntity(String name) {
		this.name = name;
		this.parent = null;
	}

	public String getName() {
		return name;
	}

	public Directory getParent() {
		return parent;
	}

	public void setParent(Directory parent) {
		this.parent = parent;
	}

	public abstract void delete();
}

// File class
class File extends FileSystemEntity {

	public File(String name) {
		super(name);
	}

	@Override
	public void delete() {
		if (parent != null) {
			parent.removeEntity(this);
		}
	}
}

// Directory class
class Directory extends FileSystemEntity {
	private List<FileSystemEntity> children;

	public Directory(String name) {
		super(name);
		this.children = new ArrayList<>();
	}

	public void addEntity(FileSystemEntity entity) {
		entity.setParent(this);
		children.add(entity);
	}

	public void removeEntity(FileSystemEntity entity) {
		children.remove(entity);
	}

	public File createFile(String name) {
		File newFile = new File(name);
		addEntity(newFile);
		return newFile;
	}

	public Directory createDirectory(String name) {
		Directory newDirectory = new Directory(name);
		addEntity(newDirectory);
		return newDirectory;
	}

	public FileSystemEntity search(String name) {
		for (FileSystemEntity entity : children) {
			if (entity.getName().equals(name)) {
				return entity;
			} else if (entity instanceof Directory) {
				FileSystemEntity found = ((Directory) entity).search(name);
				if (found != null) {
					return found;
				}
			}
		}
		return null;
	}

	@Override
	public void delete() {
		if (parent != null) {
			parent.removeEntity(this);
		}
		for (FileSystemEntity entity : new ArrayList<>(children)) {
			entity.delete();
		}
	}

	public List<String> listContents() {
		return children.stream().map(FileSystemEntity::getName).collect(Collectors.toList());
	}
}

// Main class to demonstrate the file system operations
public class FileSystem {
	public static void main(String[] args) {
		Directory root = new Directory("root");

		Directory dir1 = root.createDirectory("dir1");
		dir1.createFile("file1.txt");
		dir1.createFile("file2.txt");

		Directory dir2 = root.createDirectory("dir2");
		dir2.createFile("file3.txt");

		System.out.println("Contents of root: " + root.listContents());
		System.out.println("Contents of dir1: " + dir1.listContents());
		System.out.println("Contents of dir2: " + dir2.listContents());

		FileSystemEntity foundFile = root.search("file3.txt");
		if (foundFile != null) {
			System.out.println("Found: " + foundFile.getName());
		} else {
			System.out.println("File not found.");
		}

		dir1.delete();
		System.out.println("Contents of root after deleting dir1: " + root.listContents());
	}
}
