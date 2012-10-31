package de.bht.fpa.mail.s749711.utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import de.bht.fpa.mail.s749711.items.DirectoryItem;

public class History {
  private static History instance = null;
  private DirectoryItem baseDirectory;
  private ArrayList<String> baseDirectoryHistory;
  private final File homeDirectory;
  private final File historyFile;
  private final String appDirName = ".fpamailer";
  private final String historyFileName = "history.txt";

  private History() {
    // build the path string
    this.homeDirectory = new File(System.getProperty("user.home") + "\\" + this.appDirName);
    if (!this.homeDirectory.exists()) {
      System.out.println("Creating app dir: " + this.homeDirectory.getAbsolutePath());
      this.homeDirectory.mkdir();
    }
    // initialize list of entries if there are any
    this.historyFile = new File(this.homeDirectory.getAbsolutePath() + "\\" + this.historyFileName);
    if (!this.historyFile.exists()) {
      try {
        this.historyFile.createNewFile();
      } catch (IOException e) {
        throw new RuntimeException("Exception not handled in code", e);
      }
    } else {
      // file might exist but is empty, we skip scanning it then
      if (this.historyFile.length() != 0) {
        try {
          if (this.baseDirectoryHistory == null) {
            this.baseDirectoryHistory = new ArrayList<String>();
          }
          Scanner scanner = new Scanner(new FileReader(this.historyFile));
          scanner.useDelimiter(";");
          while (scanner.hasNext()) {
            this.baseDirectoryHistory.add(scanner.next());
          }
        } catch (FileNotFoundException e) {
          throw new RuntimeException("Exception not handled in code", e);
        }
      }
    }
  }

  public static History getInstance() {
    if (instance == null) {
      instance = new History();
    }
    return instance;
  }

  public DirectoryItem getBaseDirectory() {
    return baseDirectory;
  }

  public void setDirectoryItem(DirectoryItem directoryItem) {
    this.baseDirectory = directoryItem;
  }

  public String[] getHistory() {
    String[] arr = new String[0];
    if (this.baseDirectoryHistory == null) {
      return new String[] { "No base directories in history dude" };
    }
    return this.baseDirectoryHistory.toArray(arr);
  }

  public void setHistory(String path) {
    try {
      if (this.historyFile.exists()) {
        FileWriter fw = new FileWriter(this.historyFile.getAbsolutePath(), true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(path + ";");
        bw.close();
      }
    } catch (IOException e) {
      // TODO Handle suppressed exception
      throw new RuntimeException("Exception not handled in code", e);
    }
    if (this.baseDirectoryHistory == null) {
      this.baseDirectoryHistory = new ArrayList<String>();
    }
    this.baseDirectoryHistory.add(path);
  }
}
