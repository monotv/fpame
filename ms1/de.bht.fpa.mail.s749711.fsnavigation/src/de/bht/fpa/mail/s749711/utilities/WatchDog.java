package de.bht.fpa.mail.s749711.utilities;

import java.util.Observable;

import de.bht.fpa.mail.s749711.items.DirectoryItem;

public class WatchDog extends Observable {
  private static WatchDog instance = null;
  private DirectoryItem baseDirectory;

  private WatchDog() {

  }

  public static WatchDog getInstance() {
    if (instance == null) {
      instance = new WatchDog();
    }
    return instance;
  }

  public DirectoryItem getBaseDirectory() {
    return baseDirectory;
  }

  public void setDirectoryItem(DirectoryItem directoryItem) {
    this.baseDirectory = directoryItem;
    setChanged();
    notifyObservers(this.baseDirectory);
  }

  public void applicationStart() {
    setChanged();
    notifyObservers("app.start");
  }

}
