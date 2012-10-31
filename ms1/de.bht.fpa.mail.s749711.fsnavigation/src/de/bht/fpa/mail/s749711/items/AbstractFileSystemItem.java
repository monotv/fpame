package de.bht.fpa.mail.s749711.items;

import java.io.File;

public abstract class AbstractFileSystemItem {

  public File getFile() {
    return null;
  }

  public String getName() {
    return null;
  }

  public boolean isHidden() {
    return false;
  }

  public AbstractFileSystemItem[] getChildren() {
    return null;
  }
}
