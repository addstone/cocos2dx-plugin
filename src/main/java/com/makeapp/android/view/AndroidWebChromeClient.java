package com.makeapp.android.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.makeapp.javase.log.LogUtil;

/**
 * Created by IntelliJ IDEA.
 * User: yuanyou
 * Date: 11-6-10
 * Time: ����10:55
 */
public class AndroidWebChromeClient extends WebChromeClient {
    private Activity context = null;

    int prom_dialog;

    public AndroidWebChromeClient(Activity context, int prom_dialog) {
        this.context = context;
        this.prom_dialog = prom_dialog;
    }

    public AndroidWebChromeClient(Activity context) {
        this.context = context;
    }

    public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
        //����һ��Builder����ʾ��ҳ�е�alert�Ի���
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("��ʾ�Ի���");
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }

        });
        builder.setCancelable(false);
        builder.create();
        builder.show();

//        Dialog dialog = new Dialog(context);
//        dialog.setContentView(R.layout.alert);
//        dialog.show();
        return true;
    }

    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("��ѡ��ĶԻ���");
        builder.setMessage(message);
        builder.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                result.confirm();
            }

        });
        builder.setNeutralButton(android.R.string.cancel, new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                result.cancel();
            }

        });
        builder.setCancelable(false);
        builder.create();
        builder.show();
        return true;
    }

    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View v = inflater.inflate(prom_dialog, null);
        //���� TextView��Ӧ��ҳ�е���ʾ��Ϣ
//        ((TextView) v.findViewById(R.id.TextView_PROM)).setText(message);
        //����EditText��Ӧ��ҳ�е������
//        ((EditText) v.findViewById(R.id.EditText_PROM)).setText(defaultValue);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("������ĶԻ��� ");
        builder.setView(v);
        builder.setPositiveButton(android.R.string.ok, new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
//                String value = ((EditText) v.findViewById(R.id.EditText_PROM)).getText().toString();
//                result.confirm(value);
            }

        });
        builder.setNegativeButton(android.R.string.cancel, new AlertDialog.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                result.cancel();
            }

        });
        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {

            public void onCancel(DialogInterface dialog) {
                result.cancel();
            }

        });
        builder.create();
        builder.show();
        return true;
    }

    //������ҳ���صĽ�����
    public void onProgressChanged(WebView view, int newProgress) {
        context.getWindow().setFeatureInt(Window.FEATURE_PROGRESS, newProgress * 100);
        super.onProgressChanged(view, newProgress);
    }

    //����Ӧ�ó���ı���
    public void onReceivedTitle(WebView view, String title) {
        context.setTitle(title);
        super.onReceivedTitle(view, title);
    }

    @Override
    public boolean onCreateWindow(WebView view, boolean dialog, boolean userGesture, Message resultMsg) {
        LogUtil.info("onCreateWindow");
        return super.onCreateWindow(view, dialog, userGesture, resultMsg);
    }

    @Override
    public void onCloseWindow(WebView window) {
        LogUtil.info("onCloseWindow");
        super.onCloseWindow(window);
    }
}
