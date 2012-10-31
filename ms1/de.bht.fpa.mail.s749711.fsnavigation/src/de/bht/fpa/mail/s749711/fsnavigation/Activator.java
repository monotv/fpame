package de.bht.fpa.mail.s749711.fsnavigation;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;

/**
 * The activator class controls the plug-in life cycle
 */
public class Activator extends AbstractUIPlugin {

  // The plug-in ID
  public static final String PLUGIN_ID = "de.bht.fpa.mail.s749711.fsnavigation"; //$NON-NLS-1$
  public static final String DIRECTORY_ITEM = "image.directory.item";
  public static final String FILE_ITEM = "image.file.item";

  // The shared instance
  private static Activator plugin;

  /**
   * The constructor
   */
  public Activator() {
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext
   * )
   */
  @Override
  public void start(BundleContext context) throws Exception {
    super.start(context);
    plugin = this;
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext
   * )
   */
  @Override
  public void stop(BundleContext context) throws Exception {
    plugin = null;
    super.stop(context);
  }

  @Override
  protected void initializeImageRegistry(ImageRegistry registry) {
    super.initializeImageRegistry(registry);
    Bundle bundle = Platform.getBundle(PLUGIN_ID);
    ImageDescriptor image = ImageDescriptor.createFromURL(FileLocator.find(bundle, new Path("icons/folder.png"), null));
    registry.put(DIRECTORY_ITEM, image);
    image = ImageDescriptor.createFromURL(FileLocator.find(bundle, new Path("icons/page.png"), null));
    registry.put(FILE_ITEM, image);
  }

  /**
   * Returns the shared instance
   * 
   * @return the shared instance
   */
  public static Activator getDefault() {
    return plugin;
  }

}
