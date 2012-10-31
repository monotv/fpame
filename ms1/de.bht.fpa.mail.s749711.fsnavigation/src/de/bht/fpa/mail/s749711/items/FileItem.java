package de.bht.fpa.mail.s749711.items;

import java.io.File;

public class FileItem extends AbstractFileSystemItem {

  private final File file;
  private final String name;
  private final boolean isHidden;

  public FileItem(File file) {
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
}
