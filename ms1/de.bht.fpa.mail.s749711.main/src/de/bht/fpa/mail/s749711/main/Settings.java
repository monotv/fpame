package de.bht.fpa.mail.s749711.main;

public final class Settings {
  private static final int INITIAL_WIDTH = 800;
  private static final int INITIAL_HEIGHT = 600;
  /*
   * TODO let user choose path, this is only for dev
   */
  private static String rootPath = "D:\\privat\\studium";

  private Settings() {

  }

  public static int getInitialWidth() {
    return INITIAL_WIDTH;
  }

  public static int getInitialHeight() {
    return INITIAL_HEIGHT;
  }

  public static String getRootPath() {
    return rootPath;
  }

}
