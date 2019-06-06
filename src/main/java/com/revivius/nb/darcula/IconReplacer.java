package com.revivius.nb.darcula;

import org.openide.filesystems.FileObject;
import org.openide.filesystems.FileUtil;
import org.openide.util.NbPreferences;
import org.openide.windows.OnShowing;

import javax.swing.*;
import java.util.logging.Logger;
import java.util.prefs.Preferences;

@OnShowing
public class IconReplacer implements Runnable{

    public static final String ICON_DIR = "com/geometror/darcularemix/icons/";

    @Override
    public void run() {

        Preferences prefs = NbPreferences.root();
        int prefChosenOpt = prefs.getInt("replaceIcons_chosenOption",-1);

        if(prefChosenOpt == -1){
            int chosenOpt = JOptionPane.showConfirmDialog(null,
                    "Should new icons be installed?",
                    "Choose",
                    JOptionPane.YES_NO_OPTION);
            prefs.putInt("replaceIcons_chosenOption", chosenOpt);
            prefChosenOpt = chosenOpt;
        }
        if (prefChosenOpt == JOptionPane.YES_OPTION) {
            replaceAllIcons();
        }

        printFileSystemTree(); //Debug

    }

    private void replaceAllIcons() {
        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-OpenProject.instance",
                "openProject");

        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-RunSingle.instance",
                "runFile");
        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-RunMainProject.instance",
                "run");
        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-BuildMainProject.instance",
                "build");
        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-RebuildMainProject.instance",
                "cleanBuild");

        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-NewFile.instance",
                "newFile");

        replaceIcon("Actions/System/org-openide-actions-SaveAllAction.instance",
                "saveAll");
        replaceIcon("Actions/Edit/org-openide-actions-UndoAction.instance",
                "undo");
        replaceIcon("Actions/Edit/org-openide-actions-RedoAction.instance",
                "redo");

        replaceIcon("Actions/Project/org-netbeans-modules-web-clientproject-browser-ActiveBrowserAction.instance",
                "redo");

        replaceIcon("Actions/Project/org-netbeans-modules-project-ui-NewProject.instance",
                "newFile");

    }

    private void replaceIcon(String configObj, String iconName){
        Action newFileAction =
                FileUtil.getConfigObject(configObj, Action.class);

        newFileAction.putValue("iconBase", ICON_DIR + iconName + ".png");
        newFileAction.putValue("PreferredIconSize", 24);

    }

    private void printFileSystemTree(){
        FileObject fo = FileUtil.getConfigFile("Actions/");
        FileObject[] fos = fo.getChildren();
        for(FileObject fa: fos){
            for(FileObject fb: fa.getChildren()){
                Logger.getGlobal().info("FileObject: " + fb.getPath());
            }
            Logger.getGlobal().info("DIREND");
        }
    }
}
