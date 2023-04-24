//package fh.uebung.tictactoe.GithubAction
//
//
//import kotlinx.cinterop.toKString
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//import platform.UIKit.*
//
//class TextLogWindow {
//    fun showWindow() {
//        val alertController = UIAlertController.alertControllerWithTitle(
//            title = "Text eingeben",
//            message = null,
//            preferredStyle = UIAlertControllerStyleUIAlertControllerStyleAlert
//        )
//
//        alertController.addTextFieldWithConfigurationHandler { textField ->
//            textField.placeholder = "Geben Sie hier Ihren Text ein"
//        }
//
//        alertController.addAction(
//            UIAlertAction.actionWithTitle(
//                title = "Abschicken",
//                style = UIAlertActionStyleUIAlertActionStyleDefault,
//                handler = { _ ->
//                    val text = alertController.textFields!![0].text.toKString()
//                    logText(text)
//                }
//            )
//        )
//
//        alertController.addAction(
//            UIAlertAction.actionWithTitle(
//                title = "Abbrechen",
//                style = UIAlertActionStyleUIAlertActionStyleCancel,
//                handler = null
//            )
//        )
//
//        UIApplication.sharedApplication.keyWindow?.rootViewController?.presentViewController(
//            viewControllerToPresent = alertController,
//            animated = true,
//            completion = null
//        )
//    }
//
//    private fun logText(text: String) {
//        GlobalScope.launch(Dispatchers.Default) {
//            val filePath = "log.txt"
//            val file = fopen(filePath, "a") ?: throw IllegalStateException("Cannot open file $filePath")
//
//            try {
//                fprintf(file, "%s\n", text)
//            } finally {
//                fclose(file)
//            }
//        }
//    }
//}
