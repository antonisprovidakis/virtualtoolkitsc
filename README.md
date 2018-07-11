# VirtualToolkitSC
A (prototype) collaborative toolkit that supports Swing (desktop), AWT (desktop), GWT (web). The (basic) collaboration is achieved through the Firebase Realtime Database.

Instructions:

GWT 2.8.2+ must be used.
This software was implemented in Eclipse using GWT Eclipse Plugin (V3), which makes working with GWT a lot easier.

Replace "virtualtoolkitsc-firebase-credentials.json" file with your own.
Also, "NonGWTFirebaseSyncManager.java" and "GWTFirebaseSyncManager.java" files should be updated manually in order to setup firebase.


For a high-level overview of the project, see "virtual_toolkit_sc_class_diagram.png" included in "documentation" folder.

---------------------------------------------------
This project is based on the work of Jacob W. Bartel and Prasun Dewan, described in the paper: "Towards multi-domain collaborative toolkits" [https://dl.acm.org/citation.cfm?id=2145204.2145398]

Source code of the original toolkit is hosted at: https://github.com/jwbartel/VirtualToolkit