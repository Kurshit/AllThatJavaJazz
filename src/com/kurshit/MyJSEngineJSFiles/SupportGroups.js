var FRAMEWORK = {
    convertToDateTimeObject: function(value) {
        var userDetails = com.tcs.splus.util.UserFactory.getCurrentTimeStampDetails(com.tcs.sp.jdbc.Impl.JDBCSessionBuilder.instance().build(globalConnection), ORGID, USERPK);
        var returnData = null;
        if (userDetails != null && !userDetails.isEmpty()) {
            returnData = com.tcs.splus.util.getDateTimeObjectForGivenString(userDetails.get('javaDateFormat') + ' ' + userDetails.get('javaTimeFormat'), null, userDetails.get('timeZone'), value, null, null, null)
        }
        return returnData;
    },
    convertToDateObject: function(value) {
        var userDetails = com.tcs.splus.util.UserFactory.getCurrentTimeStampDetails(com.tcs.sp.jdbc.Impl.JDBCSessionBuilder.instance().build(globalConnection), ORGID, USERPK);
        var returnData = null;
        if (userDetails != null && !userDetails.isEmpty()) {
            returnData = com.tcs.splus.util.getDateTimeObjectForGivenString(userDetails.get('javaDateFormat'), null, userDetails.get('timeZone'), value, null, null, null)
        }
        return returnData;
    },
    getLocaleByUserId: function(userId) {
        var locale = 'en';
        locale = com.tcs.cp.i18n.util.I18nUtil.getLanguageForUserByUserId(globalConnection, userId, ORGID);
        return locale;
    },
    getFileSize: function(filePath) {
        var fizeSize = 0;
        var file = new java.io.File(FilePath);
        if (file.exists()) {
            fizeSize = (java.lang.Double)(file / 1024);
        }
        return fileSize;
    },
    attachWorkflow: function(entityType, userId) {
        var workflowVO = new com.tcs.asm.platform.vo.workflow.WorkflowVO();
        workflowVO.setOrgId(ORGID);
        workflowVO.setEntityType(entityType);
        workflowVO.setCurrentTime(FRAMEWORK.getCurrentTime());
        workflowVO.setCurrentUserAU2CMId(FRAMEWORK.getAppUser2CompanyMapIdByUserId(userId));
        var globalJdbcSession = com.tcs.sp.jdbc.Impl.JDBCSessionBuilder.instance().build(globalConnection);
        var customerJdbcSession = com.tcs.sp.jdbc.Impl.JDBCSessionBuilder.instance().build(customerConnection);
        var jdbcSessionStore = com.tcs.splus.vo.JDBCSessionStore();
        jdbcSessionStore.setMspGlobalSession(globalJdbcSession);
        jdbcSessionStore.setCustomerSession(customerJdbcSession);
        new com.tcs.asm.platform.service.WorkflowServiceBeanImpl().handleImportAtGivenStatus(jdbcSessionStore, workflowVO);
    },
    getCurrentTime: function() {
        return com.tcs.splus.util.DateTimeUtil.getCurrentTime();
    },
    getSelectQuery: function(schemaName) {
        var obj;
        if (schemaName != null && schemaName.equals('MSPGLOBAL') && globalConnection != null) {
            conn = globalConnection;
        } else if (schemaName != null && schemaName.equals('CUSTOMER') && customerConnection != null) {
            conn = customerConnection;
        }
        if (conn != null) {
            obj = com.tcs.sp.jdbc.Impl.JDBCSessionBuilder.instance().build(conn).prepareSelectQuery();
        }
        return obj;
    },
    getLogger: function(useCaseName) {
        var obj;
        obj = com.tcs.sp.scripts.ScriptLogger.getInstance(useCaseName, ORGID, APPID);
        return obj;
    },
    throwBusinessException: function(message) {
        throw new com.tcs.splus.exception.BusinessException(com.tcs.splus.util.Module.FRAMEWORK, message);
    },
    getRelation: function(relationName) {
        return RL_UTIL.getRelation(relationName)
    },
    getAppUser2CompanyMapIdByUserId: function(userId) {
        return com.tcs.asm.platform.entity.AppUser2CompanyMapFactory.getAppUser2CompanyMapId(com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection), userId, ORGID)
    },
    getBaseDirectoryPathByFolderId: function(folderId) {
        var systemUserDBId = com.tcs.splus.util.SystemUserFactory.getSystemUserDbIdByOrgId(com.tcs.sp.jdbc.Impl.JDBCSessionBuilder.instance().build(globalConnection), ORGID);
        return com.tcs.splus.util.FileUtils.getFilePath(systemUserDBId, ORGID, APPID, folderId);
    },
    copyAttachment: function(source, destinationLocation) {
        var sourceFile = new java.io.File(source);
        var destinationDirectory = new java.io.File(destinationLocation);
        org.apache.commons.io.FileUtils.copyFileToDirectory(sourceFile, destinationDirectory);
    },
    getI18nMessage: function(messageId) {
        var baseVO = new com.tcs.splus.vo.BaseVO();
        baseVO.setOrgId(ORGID);
        var userId = com.tcs.asm.platform.entity.AppUserFactory.getUserIdById(com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection), USERPK, baseVO);
        var locale = FRAMEWORK.getLocaleByUserId(userId);
        var i18nParamVO = new com.tcs.cp.i18n.vo.I18nParamVO(ORGID, APPID);
        i18nParamVO.setLocale(locale);
        i18nParamVO.setLocaleId(locale);
        i18nParamVO.setUserId(userId);
        i18nParamVO.setCurrentUser(userId);
        i18nParamVO.setCurrentUserAU2CMId(USERPK);
        i18nParamVO.setOrgId(ORGID);
        i18nParamVO.setMessageId(messageId);
        var service = com.tcs.cp.i18n.service.I18nServiceBuilder.instance().build();
        var workflowMessage = service.getMessagesByMessageId(i18nParamVO);
        if (workflowMessage == null) {
            i18nParamVO.setMessageId('ERROR_MESSAGE_ID');
            workflowMessage = service.getMessagesByMessageId(i18nParamVO);
        }
        return workflowMessage;
    }
};
var SM = {
    getClassificationIdByPath: function(pathMap) {
        var session;
        var classificationId = null;
        if (globalConnection != null) {
            session = com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection);
            var baseVO = new com.tcs.splus.vo.BaseVO();
            baseVO.setOrgId(ORGID);
            classificationId = com.tcs.asm.platform.entity.ClassificationFactory.findClassificationIdByFormattedPath(session, baseVO, pathMap);
        }
        return classificationId;
    },
    getIdByLocationPath: function(locationPath) {
        var baseVO = new com.tcs.splus.vo.BaseVO();
        baseVO.setOrgId(ORGID);
        return com.tcs.asm.platform.entity.LocationFactory.getIdUsingFormattedPath(com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection), locationPath, ORGID, baseVO)
    },
    getSelectFieldsConfiguration: function(entityType) {
        var baseVO = new com.tcs.splus.vo.BaseVO();
        baseVO.setOrgId(ORGID);
        baseVO.setSecObj(entityType);
        baseVO.setUseCase(entityType);
        baseVO.setEntityName(entityType);
        baseVO.setEntityInstanceId(ORGID);
        return com.tcs.asm.sd.common.util.FetchFieldsUtility.getFieldInfoWithMasterData(globalConnection, baseVO)
    },
    getSupportGroupIdByName: function(groupName) {
        var baseVO = new com.tcs.splus.vo.BaseVO();
        baseVO.setOrgId(ORGID);
        return com.tcs.asm.platform.entity.SupportGroupFactory.getSGIdByNameAndCmpId(com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection), ORGID, groupName, baseVO);
    },
    getApproalGroupIdByName: function(groupName) {
        var baseVO = new com.tcs.splus.vo.BaseVO();
        baseVO.setOrgId(ORGID);
        return com.tcs.asm.platform.entity.SupportGroupFactory.getAGIdByNameAndCmpId(com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection), ORGID, groupName, baseVO);
    },
    getCustomFieldEntityId: function(entityType) {
        var baseVO = new com.tcs.splus.vo.BaseVO();
        baseVO.setOrgId(ORGID);
        return com.tcs.asm.platform.entity.CustomFieldEntityFactory.findByEntityTypeAndOrgId(com.tcs.splus.HibernateUtils.getSessionFactory().openStatelessSession(globalConnection), baseVO, entityType);
    },
    hasAllRoles: function() {
        var n = !1;
        for (x in arguments)
            if (n = uRoles.contains(arguments[x]), !n) break;
        return n
    },
    hasAnyRole: function() {
        var n = !1;
        for (x in arguments)
            if (n = uRoles.contains(arguments[x])) break;
        return n
    },
    belongsToAllSupportGroups: function() {
        var n = !1;
        for (x in arguments)
            if (n = uSG.contains(arguments[x]), !n) break;
        return n
    },
    belongsToAnySupportGroup: function() {
        var n = !1;
        for (x in arguments)
            if (n = uSG.contains(arguments[x])) break;
        return n
    },
    belongsToAllUserGroups: function() {
        var n = !1;
        for (x in arguments)
            if (n = uUG.contains(arguments[x]), !n) break;
        return n
    },
    belongsToAnyUserGroup: function() {
        var n = !1;
        for (x in arguments)
            if (n = uUG.contains(arguments[x])) break;
        return n
    }
};
var UMB = {
    convertExcelDateToDbDate: function(inputDate, timeZone) {
        var dateData = (inputDate != null && !"".equals(inputDate) && !isNaN(inputDate)) ? org.apache.poi.ss.usermodel.DateUtil.getJavaDate(inputDate * 1, java.util.TimeZone.getTimeZone(timeZone)) : null;
        var returnDate = null;
        if (dateData != null) {
            returnDate = new java.sql.Timestamp(dateData.getTime());
        }
        return returnDate;
    }
};