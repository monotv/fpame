package de.bht.fpa.mail.s749711.fsnavigation;

import java.io.File;
import java.util.Observable;
import java.util.Observer;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import de.bht.fpa.mail.s749711.items.DirectoryItem;
import de.bht.fpa.mail.s749711.utilities.WatchDog;

public class NavigationView extends ViewPart implements Observer {
  public static final String ID = "de.bht.fpa.s<MATRIKELNUMMER>.fsnavigation.NavigationView";
  private TreeViewer viewer;

  /**
   * This is a callback that will allow us to create the viewer and initialize
   * it.
   */
  @Override
  public void createPartControl(Composite parent) {
    // Observer business
    WatchDog.getInstance().addObserver(this);

    // a TreeViewer is a Jface widget, which shows trees
    viewer = new TreeViewer(parent, SWT.MULTI | SWT.H_SCROLL | SWT.V_SCROLL | SWT.BORDER);

    // We set the ContentProvider for the TreeViewer. This class prepares data
    // to be shown by the TreeViewer.
    viewer.setContentProvider(new ViewContentProvider());

    // We set the LabelProvider. This class decides how elements in the tree are
    // shown by returning a text and an optional icon.
    viewer.setLabelProvider(new ViewLabelProvider());

    // Here we set the root of the tree. The framework will ask for more data
    // when the user expands tree items.
    viewer.setInput(createModel());
  }

  /**
   * We will set up a model to initialize tree hierarchy.
   */
  private Object createModel() {
    // Our root item is simply a dummy Object. Here you need to provide your own
    // root class.
    File file = new File(System.getProperty("user.home"));
    return new DirectoryItem(file);
  }

  /**
   * Passing the focus request to the viewer's control.
   */
  @Override
  public void setFocus() {
    viewer.getControl().setFocus();
  }

  @Override
  public void update(Observable obs, Object obj) {
    if (obj instanceof DirectoryItem) {
      System.out.println(obj.toString());
      viewer.setInput(obj);
    }
  }
}