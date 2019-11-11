import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Button;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Encryption {

	protected Shell shlXorEncryption;
	private Text text;
	private Text text_1;
	private Text text_2;
	private Label lblMessageForEncryption;

	/**
	 * Launch the application.
	 * @param args
	 */
	public static String EncryptOrDecrypt(String message, char key)
	{
		String modifiedMessage = "";
		int messageLength = message.length();
		for (int i=0; i<messageLength; i++)
		{
			modifiedMessage = modifiedMessage + Character.toString((char) (message.charAt(i) ^ key));
		}
		return modifiedMessage;
	}
	
	public static void main (String[] args) {
		try {
			Encryption window = new Encryption();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while (true) {
			
		
		}
		
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shlXorEncryption.open();
		shlXorEncryption.layout();
		while (!shlXorEncryption.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shlXorEncryption = new Shell();
		shlXorEncryption.setBackground(SWTResourceManager.getColor(0, 0, 0));
		shlXorEncryption.setSize(629, 470);
		shlXorEncryption.setText("XOR Encryption & Decryption");
		
		lblMessageForEncryption = new Label(shlXorEncryption, SWT.NONE);
		lblMessageForEncryption.setForeground(SWTResourceManager.getColor(224, 255, 255));
		lblMessageForEncryption.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblMessageForEncryption.setBounds(32, 46, 230, 36);
		lblMessageForEncryption.setText("Message To Encrypt/Decrypt:");
		
		text = new Text(shlXorEncryption, SWT.BORDER);
		text.setBackground(SWTResourceManager.getColor(224, 255, 255));
		text.setBounds(293, 44, 274, 38);
		
		Label lblKeycharacter = new Label(shlXorEncryption, SWT.NONE);
		lblKeycharacter.setForeground(SWTResourceManager.getColor(224, 255, 255));
		lblKeycharacter.setBackground(SWTResourceManager.getColor(0, 0, 0));
		lblKeycharacter.setBounds(32, 112, 202, 38);
		lblKeycharacter.setText("Key (Character): ");
		
		text_1 = new Text(shlXorEncryption, SWT.BORDER);
		text_1.setBackground(SWTResourceManager.getColor(224, 255, 255));
		text_1.setBounds(293, 110, 274, 36);
		
		Button btnEncrypt = new Button(shlXorEncryption, SWT.NONE);
		btnEncrypt.setBackground(SWTResourceManager.getColor(128, 0, 0));
		btnEncrypt.setForeground(SWTResourceManager.getColor(224, 255, 255));
		btnEncrypt.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				char xorKey = text_1.getText().charAt(0);
				text_2.setText(EncryptOrDecrypt(text.getText(), xorKey));
				}
			
		});
		btnEncrypt.setBounds(187, 202, 208, 59);
		btnEncrypt.setText("ENCRYPT/DECRYPT");
		
		text_2 = new Text(shlXorEncryption, SWT.BORDER);
		text_2.setBackground(SWTResourceManager.getColor(224, 255, 255));
		text_2.setBounds(121, 307, 331, 59);

	}
	public String getLblMessageForEncryptionText() {
		return lblMessageForEncryption.getText();
	}
	public void setLblMessageForEncryptionText(String text_3) {
		lblMessageForEncryption.setText(text_3);
	}
}
