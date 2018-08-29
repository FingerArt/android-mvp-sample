package ${packageName};

import android.os.Bundle;
import android.support.annotation.Nullable;
<#if generateLayout>
<#if applicationPackage??>
import ${applicationPackage}.R;
</#if>
</#if>

public class ${activityClass} extends  ${superClass} implements ${contractClass}.View {

    private ${presenterClass} mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        <#if generateLayout>
        setContentView(R.layout.${layoutName});
        </#if>
    }
}