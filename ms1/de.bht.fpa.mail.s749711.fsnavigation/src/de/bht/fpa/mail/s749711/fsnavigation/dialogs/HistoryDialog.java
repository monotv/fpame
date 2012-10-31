package de.bht.fpa.mail.s749711.fsnavigation.dialogs;

import java.io.File;

import org.eclipse.jface.dialogs.Dialog;
import org.eclipse.jface.dialogs.IDialogConstants;
import org.eclipse.jface.viewers.ArrayContentProvider;
import org.eclipse.jface.viewers.ListViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Shell;

import de.bht.fpa.mail.s749711.items.DirectoryItem;
import de.bht.fpa.mail.s749711.utilities.History;
import de.bht.fpa.mail.s749711.utilities.WatchDog;

public class HistoryDialog extends Dialog {

  private ListViewer viewer;

  /**
   * Create the dialog.
   * 
   * @param parentShell
   */
  public HistoryDialog(Shell parentShell) {
    super(parentShell);
  }

  /**
   * Create contents of the dialog.
   * 
   * @param parent
   */
  @Override
  protected Control createDialogArea(Composite parent) {
    Composite container = (Composite) super.createDialogArea(parent);
    this.viewer = new ListViewer(parent, SWT.BORDER | SWT.SINGLE | SWT.V_SCROLL);
    // style the list
    this.viewer.getList().setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true, 1, 1));
    this.viewer.setContentProvider(ArrayContentProvider.getInstance());
    // set the input to the array we get from History
    this.viewer.setInput(History.getInstance().getHistory());
    return container;
  }

  /**
   * Create contents of the button bar.
   * 
   * @param parent
   */
  @Override
  protected void createButtonsForButtonBar(Composite parent) {
    createButton(parent, IDialogConstants.OK_ID, IDialogConstants.OK_LABEL, true);
    createButton(parent, IDialogConstants.CANCEL_ID, IDialogConstants.CANCEL_LABEL, false);
  }

  @Override
  protected void okPressed() {
    String[] selection = this.viewer.getList().getSelection();
    if (selection != null) {
      if (selection.length > 0) {
        WatchDog.getInstance().setDirectoryItem(new DirectoryItem(new File(selection[0])));
      }
    }
    super.okPressed();
  }

  /**
   * Return the initial size of the dialog.
   */
  @Override
  protected Point getInitialSize() {
    return new Point(450, 300);
  }

}
