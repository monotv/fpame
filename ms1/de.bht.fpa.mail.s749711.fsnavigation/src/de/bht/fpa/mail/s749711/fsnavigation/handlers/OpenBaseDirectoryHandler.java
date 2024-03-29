package de.bht.fpa.mail.s749711.fsnavigation.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import de.bht.fpa.mail.s749711.fsnavigation.dialogs.HistoryDialog;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * 
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class OpenBaseDirectoryHandler extends AbstractHandler {
  /**
   * The constructor.
   */
  public OpenBaseDirectoryHandler() {
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

    HistoryDialog historyDialog = new HistoryDialog(window.getShell());
    historyDialog.open();
    return null;
  }
}