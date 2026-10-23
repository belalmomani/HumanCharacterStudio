# Human Studio 3D — ما استُخرج من أرشيفك (مشروع منفصل عن Character Studio)

هذا المحتوى كان داخل الأرشيف نفسه مع Character Studio، لكنه تطبيق مختلف (حزمة `com.humanstudio3d`، تحويل صورة إلى نموذج 3D، عارض Filament، خادم بايثون).
الملفات هنا كما وصلتني دون تعديل.

## ما ينقص (استُبدل أو لم يكن في الأرشيف)
هذه الملفات حلّت محلها ملفات Character Studio أو لم تُرفق، فيلزم استرجاعها من مستودعك الأصلي أو نسخك الاحتياطية:
- `app/build.gradle.kts` و`build.gradle.kts` و`settings.gradle.kts` و`gradle/libs.versions.toml`
  (تذكر وثائق المشروع: AGP 8.6.1 وKotlin 2.0.21 وFilament **1.68.2** وminSdk 26 وtargetSdk 35، ويحتاج `androidx.exifinterface`).
- `app/src/main/AndroidManifest.xml` وملفات الموارد النصية `strings.xml` و`themes.xml` وغيرها:
  الكود يشير إلى 104 مورد نصي/أيقونة غير موجود هنا (القائمة في `MISSING_RESOURCES_referenced_by_code.txt`).
- أي ملفات مخفية (نقطة في أولها) مثل `.github/workflows` و`.gitignore`، لأن الأرشفة لم تتضمنها.

## ملاحظة
لا أملك هذا المشروع وليس من عملي. الخادم `server/` ومحرك TRELLIS.2 فيه غير مختبرين حسب ملف CHANGELOG نفسه.
