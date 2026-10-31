package org.lyf.juicesshofflinepro;
import android.content.Context; import android.util.Log; import io.github.libxposed.api.XposedModule; import java.lang.reflect.*;
public final class ModernModule extends XposedModule {
 static final String TARGET="com.sonelli.juicessh", TAG="JuiceSSHOfflinePro";
 @Override public void onPackageLoaded(PackageLoadedParam p){ if(!TARGET.equals(p.getPackageName()))return; ClassLoader c=p.getDefaultClassLoader(); try {
  replace(find("com.sonelli.oi0",c,"d",Object.class), true);
  replace(find("com.sonelli.juicessh.models.User",c,"H"), true);
  replace(find("com.sonelli.juicessh.models.User",c,"w"), 365L*24*60*60*10);
  replace(find("com.sonelli.pi0",c,"m",Context.class), true);
  log(Log.INFO,TAG,"modern API 101 hooks installed");
 } catch(Throwable t){ log(Log.ERROR,TAG,"hook installation failed",t); } }
 private void replace(Method m,Object value){ hook(m).intercept(chain->value); }
 private static Method find(String n,ClassLoader c,String m,Class<?>...a)throws Exception{return Class.forName(n,false,c).getDeclaredMethod(m,a);}
}
