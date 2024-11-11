package test.com.yuuki.local;

import com.yuuki.local.*;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertYearTest {

	ConvertYear cy;

	@BeforeEach
	void setUp() {
		cy = new ConvertYear();
	}
	
	@Test
	@DisplayName("warekiToSeireki() 正常ケース：year=1")
	void warekiToSeirekiTest1() 
		throws NoSuchMethodException,
			SecurityException,
		    IllegalAccessException,
		    IllegalArgumentException,
		    InvocationTargetException {
		
        Method method = ConvertYear.class.getDeclaredMethod("warekiToSeireki", int.class, int.class, int.class);
        method.setAccessible(true);

        int actual = (int)method.invoke(cy, 1, 10, 1900);

        assertEquals(1900, actual);
	}

	@Test
	@DisplayName("warekiToSeireki() 正常ケース：year=last")
	void warekiToSeirekiTest2() 
		throws NoSuchMethodException,
			SecurityException,
		    IllegalAccessException,
		    IllegalArgumentException,
		    InvocationTargetException {
		
        Method method = ConvertYear.class.getDeclaredMethod("warekiToSeireki", int.class, int.class, int.class);
        method.setAccessible(true);

        int actual = (int)method.invoke(cy, 10, 10, 1900);

        assertEquals(1909, actual);
	}

	@Test
	@DisplayName("warekiToSeireki() 異常ケース：year=0")
	void warekiToSeirekiTest3() 
		throws NoSuchMethodException,
			SecurityException,
		    IllegalAccessException,
		    IllegalArgumentException,
		    InvocationTargetException {
		
        Method method = ConvertYear.class.getDeclaredMethod("warekiToSeireki", int.class, int.class, int.class);
        method.setAccessible(true);

        int actual = (int)method.invoke(cy, 0, 10, 1900);

        assertEquals(ConvertYear.ERROR, actual);
	}

	@Test
	@DisplayName("warekiToSeireki() 異常ケース：year=last+1")
	void warekiToSeirekiTest4() 
		throws NoSuchMethodException,
			SecurityException,
		    IllegalAccessException,
		    IllegalArgumentException,
		    InvocationTargetException {
		
        Method method = ConvertYear.class.getDeclaredMethod("warekiToSeireki", int.class, int.class, int.class);
        method.setAccessible(true);

        int actual = (int)method.invoke(cy, 11, 10, 1900);

        assertEquals(ConvertYear.ERROR, actual);
	}

	@Test
	@DisplayName("seirekiToWareki() 正常ケース")
	void seirekiToWarekiTest1() 
		throws NoSuchMethodException,
			SecurityException,
		    IllegalAccessException,
		    IllegalArgumentException,
		    InvocationTargetException {
		
        Method method = ConvertYear.class.getDeclaredMethod("seirekiToWareki", int.class, int.class);
        method.setAccessible(true);

        int actual = (int)method.invoke(cy, 2000, 1950);

        assertEquals(51, actual);
	}
	
	@Test
	@DisplayName("convert() 西暦 ⇒ 明治以前")
	void convertTest1() {
		String str = cy.convert(1867, ConvertYear.SEIREKI);
		
		assertEquals(str, ConvertYear.S_BEFORE_MEIJI);
	}

	@Test
	@DisplayName("convert() 西暦 ⇒ 明治")
	void convertTest2() {
		String str;
		
		// 明治元年(1868年)
		str = cy.convert(1868, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_MEIJI_GANNEN);
		
		// 明治2年(1869年)
		str = cy.convert(1869, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_MEIJI + "2" + ConvertYear.S_YEAR);
		
		// 明治44年(1911年)
		str = cy.convert(1911, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_MEIJI + "44" + ConvertYear.S_YEAR);		
	}

	@Test
	@DisplayName("convert() 西暦 ⇒ 大正")
	void convertTest3() {
		String str;
		
		// 大正元年(1912年)
		str = cy.convert(1912, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_TAISHO_GANNEN);
		
		// 大正2年(1913年)
		str = cy.convert(1913, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_TAISHO + "2" + ConvertYear.S_YEAR);

		// 大正14年(1925年)
		str = cy.convert(1925, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_TAISHO + "14" + ConvertYear.S_YEAR);
	}

	@Test
	@DisplayName("convert() 西暦 ⇒ 昭和")
	void convertTest4() {
		String str;
		
		// 昭和元年(1926年)
		str = cy.convert(1926, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_SHOWA_GANNEN);
		
		// 昭和2年(1927年)
		str = cy.convert(1927, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_SHOWA + "2" + ConvertYear.S_YEAR);

		// 昭和63年(1988年)
		str = cy.convert(1988, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_SHOWA + "63" + ConvertYear.S_YEAR);
	}

	@Test
	@DisplayName("convert() 西暦 ⇒ 平成")
	void convertTest5() {
		String str;
		
		// 平成元年(1989年)
		str = cy.convert(1989, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_HEISEI_GANNEN);
		
		// 平成2年(1990年)
		str = cy.convert(1990, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_HEISEI + "2" + ConvertYear.S_YEAR);

		// 平成30年(2018年)
		str = cy.convert(2018, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_HEISEI + "30" + ConvertYear.S_YEAR);
	}

	@Test
	@DisplayName("convert() 西暦 ⇒ 令和")
	void convertTest6() {
		String str;
		
		// 令和元年(2019年)
		str = cy.convert(2019, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_REIWA_GANNEN);
		
		// 令和2年(2020年)
		str = cy.convert(2020, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_REIWA + "2" + ConvertYear.S_YEAR);

		// 令和100年(2118年)（仮）
		str = cy.convert(2118, ConvertYear.SEIREKI);
		assertEquals(str, ConvertYear.S_REIWA + "100" + ConvertYear.S_YEAR);
	}
	
	@Test
	@DisplayName("convert() 西暦 ⇒ 未来")
	void convertTest7() {
		String str = cy.convert(2119, ConvertYear.SEIREKI);
		
		assertEquals(str, ConvertYear.S_NEXT_X);
	}

	@Test
	@DisplayName("convert() 明治 ⇒ 西暦")
	void convertTest8() {
		String str;
		
		// 明治0年（範囲エラー）
		str = cy.convert(0, ConvertYear.MEIJI);		
		assertEquals(str, ConvertYear.S_CV_ERROR);
		
		// 明治元年(1868年)
		str = cy.convert(1, ConvertYear.MEIJI);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1868" + ConvertYear.S_YEAR);

		// 明治45年(1912年)
		str = cy.convert(45, ConvertYear.MEIJI);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1912" + ConvertYear.S_YEAR);

		// 明治46年(範囲エラー)
		str = cy.convert(46, ConvertYear.MEIJI);		
		assertEquals(str, ConvertYear.S_CV_ERROR);		
	}

	@Test
	@DisplayName("convert() 大正 ⇒ 西暦")
	void convertTest9() {
		String str;
		
		// 大正0年（範囲エラー）
		str = cy.convert(0, ConvertYear.TAISHO);		
		assertEquals(str, ConvertYear.S_CV_ERROR);
		
		// 大正元年(1912年)
		str = cy.convert(1, ConvertYear.TAISHO);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1912" + ConvertYear.S_YEAR);

		// 大正15年(1926年)
		str = cy.convert(15, ConvertYear.TAISHO);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1926" + ConvertYear.S_YEAR);

		// 大正16年(範囲エラー)
		str = cy.convert(16, ConvertYear.TAISHO);		
		assertEquals(str, ConvertYear.S_CV_ERROR);		
	}

	@Test
	@DisplayName("convert() 昭和 ⇒ 西暦")
	void convertTest10() {
		String str;
		
		// 昭和0年（範囲エラー）
		str = cy.convert(0, ConvertYear.SHOWA);		
		assertEquals(str, ConvertYear.S_CV_ERROR);
		
		// 昭和元年(1926年)
		str = cy.convert(1, ConvertYear.SHOWA);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1926" + ConvertYear.S_YEAR);

		// 昭和64年(1989年)
		str = cy.convert(64, ConvertYear.SHOWA);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1989" + ConvertYear.S_YEAR);

		// 昭和65年(範囲エラー)
		str = cy.convert(65, ConvertYear.SHOWA);		
		assertEquals(str, ConvertYear.S_CV_ERROR);		
	}

	@Test
	@DisplayName("convert() 平成 ⇒ 西暦")
	void convertTest11() {
		String str;
		
		// 平成0年（範囲エラー）
		str = cy.convert(0, ConvertYear.HEISEI);		
		assertEquals(str, ConvertYear.S_CV_ERROR);
		
		// 平成元年(1989年)
		str = cy.convert(1, ConvertYear.HEISEI);		
		assertEquals(str, ConvertYear.S_SEIREKI + "1989" + ConvertYear.S_YEAR);

		// 平成31年(2019年)
		str = cy.convert(31, ConvertYear.HEISEI);		
		assertEquals(str, ConvertYear.S_SEIREKI + "2019" + ConvertYear.S_YEAR);

		// 平成32年(範囲エラー)
		str = cy.convert(32, ConvertYear.HEISEI);		
		assertEquals(str, ConvertYear.S_CV_ERROR);		
	}

	@Test
	@DisplayName("convert() 令和 ⇒ 西暦")
	void convertTest12() {
		String str;
		
		// 令和0年（範囲エラー）
		str = cy.convert(0, ConvertYear.REIWA);		
		assertEquals(str, ConvertYear.S_CV_ERROR);
		
		// 令和元年(2019年)
		str = cy.convert(1, ConvertYear.REIWA);		
		assertEquals(str, ConvertYear.S_SEIREKI + "2019" + ConvertYear.S_YEAR);

		// 令和100年(2118年)（仮）
		str = cy.convert(100, ConvertYear.REIWA);		
		assertEquals(str, ConvertYear.S_SEIREKI + "2118" + ConvertYear.S_YEAR);

		// 令和101年(範囲エラー)
		str = cy.convert(101, ConvertYear.REIWA);		
		assertEquals(str, ConvertYear.S_CV_ERROR);		
	}

}
