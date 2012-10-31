package de.bht.fpa.mail.s749711.fsnavigation.handlers;

import java.io.File;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.swt.widgets.DirectoryDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.bht.fpa.mail.s749711.items.DirectoryItem;
import de.bht.fpa.mail.s749711.utilities.WatchDog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class SetBaseDirectoryHandler extends AbstractHandler {
  /**
   * The constructor.
   */
  public SetBaseDirectoryHandler() {
  }

  /**
   * the command has been executed, so extract extract the needed information
   * from the application context.
   */
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException {
    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
    // MessageDialog.openInformation(window.getShell(), "Fsnavigation",
    // "Hello, Eclipse world");
    DirectoryDialog directoryDialog = new DirectoryDialog(window.getShell());
    directoryDialog.setText("Set a base directory");
    String selectedDiretory = directoryDialog.open();
    if (selectedDiretory != null) {
      WatchDog.getInstance().setDirectoryItem(new DirectoryItem(new File(selectedDiretory)));
    }
    return null;
  }
}