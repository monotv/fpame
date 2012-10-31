package de.bht.fpa.mail.s749711.fsnavigation;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.ui.plugin.AbstractUIPlugin;

import de.bht.fpa.mail.s749711.items.DirectoryItem;
import de.bht.fpa.mail.s749711.items.FileItem;

public class ViewLabelProvider extends LabelProvider {
  @Override
  public String getText(Object element) {
    // here you decide for each tree item which text to show. You usually do a
    // bunch on instanceof checks for every possible type in your tree.
    if (element instanceof FileItem) {
      return ((FileItem) element).getName();
    } else if (element instanceof DirectoryItem) {
      return ((DirectoryItem) element).getName();
    }
    return super.getText(element);
  }

  @Override
  public Image getImage(Object element) {
    // here you decide for each tree item which icon to show. You usually do a
    // bunch on instanceof checks for every possible type in your tree.
    AbstractUIPlugin plugin = Activator.getDefault();
    ImageRegistry registry = plugin.getImageRegistry();
    if (element instanceof FileItem) {
      return registry.get(Activator.FILE_ITEM);
    } else if (element instanceof DirectoryItem) {
      return registry.get(Activator.DIRECTORY_ITEM);
    }
    return super.getImage(element);
  }
}
