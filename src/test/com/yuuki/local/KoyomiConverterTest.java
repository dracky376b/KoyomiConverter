package test.com.yuuki.local;

import com.yuuki.local.*;
import static org.junit.jupiter.api.Assertions.*;

import java.awt.event.ActionEvent;
import java.lang.reflect.Field;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class KoyomiConverterTest {

	@Test
	@DisplayName("actionPerformed() 西暦")
	void actionPerformedTest1() throws Exception {
		KoyomiConverter kc = new KoyomiConverter();
		
		// private変数のフィールドを取得
		Field field = kc.getClass().getDeclaredField("rd_selected");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(kc, 0);

		ActionEvent e = new ActionEvent(kc, ActionEvent.ACTION_FIRST, KoyomiConverter.RD_SEIREKI);
		
		kc.actionPerformed(e);
		// private変数を確認
		int value = Integer.parseInt(String.valueOf(field.get(kc)));
		assertEquals(ConvertYear.SEIREKI, value);
	}

	@Test
	@DisplayName("actionPerformed() 明治")
	void actionPerformedTest2() throws Exception {
		KoyomiConverter kc = new KoyomiConverter();
		
		// private変数のフィールドを取得
		Field field = kc.getClass().getDeclaredField("rd_selected");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(kc, 0);

		ActionEvent e = new ActionEvent(kc, ActionEvent.ACTION_FIRST, KoyomiConverter.RD_MEIJI);
		
		kc.actionPerformed(e);
		// private変数を確認
		int value = Integer.parseInt(String.valueOf(field.get(kc)));
		assertEquals(ConvertYear.MEIJI, value);
	}

	@Test
	@DisplayName("actionPerformed() 大正")
	void actionPerformedTest3() throws Exception {
		KoyomiConverter kc = new KoyomiConverter();
		
		// private変数のフィールドを取得
		Field field = kc.getClass().getDeclaredField("rd_selected");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(kc, 0);

		ActionEvent e = new ActionEvent(kc, ActionEvent.ACTION_FIRST, KoyomiConverter.RD_TAISHO);
		
		kc.actionPerformed(e);
		// private変数を確認
		int value = Integer.parseInt(String.valueOf(field.get(kc)));
		assertEquals(ConvertYear.TAISHO, value);
	}

	@Test
	@DisplayName("actionPerformed() 昭和")
	void actionPerformedTest4() throws Exception {
		KoyomiConverter kc = new KoyomiConverter();
		
		// private変数のフィールドを取得
		Field field = kc.getClass().getDeclaredField("rd_selected");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(kc, 0);

		ActionEvent e = new ActionEvent(kc, ActionEvent.ACTION_FIRST, KoyomiConverter.RD_SHOWA);
		
		kc.actionPerformed(e);
		// private変数を確認
		int value = Integer.parseInt(String.valueOf(field.get(kc)));
		assertEquals(ConvertYear.SHOWA, value);
	}

	@Test
	@DisplayName("actionPerformed() 平成")
	void actionPerformedTest5() throws Exception {
		KoyomiConverter kc = new KoyomiConverter();
		
		// private変数のフィールドを取得
		Field field = kc.getClass().getDeclaredField("rd_selected");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(kc, 0);

		ActionEvent e = new ActionEvent(kc, ActionEvent.ACTION_FIRST, KoyomiConverter.RD_HEISEI);
		
		kc.actionPerformed(e);
		// private変数を確認
		int value = Integer.parseInt(String.valueOf(field.get(kc)));
		assertEquals(ConvertYear.HEISEI, value);
	}

	@Test
	@DisplayName("actionPerformed() 令和")
	void actionPerformedTest6() throws Exception {
		KoyomiConverter kc = new KoyomiConverter();
		
		// private変数のフィールドを取得
		Field field = kc.getClass().getDeclaredField("rd_selected");
		// private変数へのアクセス制限を解除
		field.setAccessible(true);
		// private変数に値を設定
		field.set(kc, 0);

		ActionEvent e = new ActionEvent(kc, ActionEvent.ACTION_FIRST, KoyomiConverter.RD_REIWA);
		
		kc.actionPerformed(e);
		// private変数を確認
		int value = Integer.parseInt(String.valueOf(field.get(kc)));
		assertEquals(ConvertYear.REIWA, value);
	}
}
