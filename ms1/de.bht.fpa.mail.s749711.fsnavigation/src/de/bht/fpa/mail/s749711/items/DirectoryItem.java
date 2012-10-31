package de.bht.fpa.mail.s749711.items;

import java.io.File;
import java.util.ArrayList;

public class DirectoryItem extends AbstractFileSystemItem {

  private final File file;
  private final String name;
  private final boolean isHidden;

  public DirectoryItem(File file) {
    this.file = file;
    this.name = this.file.getName();
    this.isHidden = this.file.isHidden();
  }

  @Override
  public File getFile() {
    return file;
  }

  @Override
  public String getName() {
    return name;
  }

  @Override
  public boolean isHidden() {
    return isHidden;
  }

  @Override
  public AbstractFileSystemItem[] getChildren() {
    File[] files = this.file.listFiles();
    ArrayList<AbstractFileSystemItem> children = new ArrayList<AbstractFileSystemItem>();
    AbstractFileSystemItem[] arr = new AbstractFileSystemItem[children.size()];
    for (int i = 0; i < files.length; i++) {
      if (files[i].isDirectory()) {
        children.add(new DirectoryItem(files[i]));
      } else {
        children.add(new FileItem(files[i]));
      }
    }
    return children.toArray(arr);
  }
}
