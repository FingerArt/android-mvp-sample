<?xml version="1.0"?>
<recipe>

<instantiate from="root/src/app_package/SimpleActivity.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${activityClass}.${ktOrJavaExt}" />

<instantiate from="root/src/app_package/SimplePresenter.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${presenterClass}.${ktOrJavaExt}" />

<instantiate from="root/src/app_package/SimpleContract.${ktOrJavaExt}.ftl"
                   to="${escapeXmlAttribute(srcOut)}/${contractClass}.${ktOrJavaExt}" />
                   
<#if generateLayout>
    <instantiate from="root/res/layout/activity_simple.xml.ftl"
                   to="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
    <open file="${escapeXmlAttribute(resOut)}/layout/${layoutName}.xml" />
</#if>

<open file="${escapeXmlAttribute(srcOut)}/${activityClass}.${ktOrJavaExt}" />
<open file="${escapeXmlAttribute(srcOut)}/${presenterClass}.${ktOrJavaExt}" />
<open file="${escapeXmlAttribute(srcOut)}/${contractClass}.${ktOrJavaExt}" />


</recipe>
