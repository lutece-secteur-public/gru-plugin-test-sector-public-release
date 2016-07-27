/*
 * Copyright (c) 2002-2015, Mairie de Paris
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *  1. Redistributions of source code must retain the above copyright notice
 *     and the following disclaimer.
 *
 *  2. Redistributions in binary form must reproduce the above copyright notice
 *     and the following disclaimer in the documentation and/or other materials
 *     provided with the distribution.
 *
 *  3. Neither the name of 'Mairie de Paris' nor 'Lutece' nor the names of its
 *     contributors may be used to endorse or promote products derived from
 *     this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDERS OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 *
 * License 1.0
 */
package fr.paris.lutece.plugins.release.web;


import javax.servlet.http.HttpServletRequest;

import fr.paris.lutece.portal.service.message.SiteMessageException;
import fr.paris.lutece.portal.service.spring.SpringContextService;
import fr.paris.lutece.portal.util.mvc.commons.annotations.Action;
import fr.paris.lutece.portal.util.mvc.commons.annotations.View;
import fr.paris.lutece.portal.util.mvc.xpage.MVCApplication;
import fr.paris.lutece.portal.util.mvc.xpage.annotations.Controller;
import fr.paris.lutece.portal.web.xpages.XPage;


/**
 * This class provides a simple implementation of an XPage
 */
@Controller( xpageName = ReleaseApp.XPAGE_NAME, pageTitleI18nKey = ReleaseApp.MESSAGE_DEFAULT_PAGE_TITLE, pagePathI18nKey = ReleaseApp.MESSAGE_DEFAULT_PATH )
public class ReleaseApp extends MVCApplication
{
    /**
     * Name of the view of the first step of the form
     */
    public static final String VIEW_APPOINTMENT_FORM_FIRST_STEP = "getAppointmentFormFirstStep";

    /**
     * Name of the view of the second step of the form
     */
    public static final String VIEW_APPOINTMENT_FORM_SECOND_STEP = "getAppointmentFormSecondStep";

    /**
     * Default page of XPages of this app
     */
    public static final String MESSAGE_DEFAULT_PATH = "appointment.appointmentApp.defaultPath";

    /**
     * Default page title of XPages of this app
     */
    public static final String MESSAGE_DEFAULT_PAGE_TITLE = "appointment.appointmentApp.defaultTitle";

    /** Infos error WorkFlow */
    private static final String INFO_APPOINTMENT_STATE_ERROR = "appointment.info.appointment.etatinitial";

    /**
     * The name of the XPage
     */
    protected static final String XPAGE_NAME = "appointment";

    /**
     * Generated serial version UID
     */
    private static final long serialVersionUID = 5741361182728887387L;

    // Templates
  // Views
    private static final String VIEW_APPOINTMENT_FORM_LIST = "getViewFormList";
   
    // Actions
    private static final String ACTION_DO_VALIDATE_FORM = "doValidateForm";
  
    // Parameters
    private static final String PARAMETER_ID_FORM = "id_form";
     private static final String PARAMETER_ID_SLOT = "idSlot";
     // Local variables
    private final fr.paris.lutece.plugins.workflowcore.service.workflow.WorkflowService _stateServiceWorkFlow = SpringContextService.getBean( fr.paris.lutece.plugins.workflowcore.service.workflow.WorkflowService.BEAN_SERVICE );
   
    
    /**
     * Get the list of appointment form list
     * @param request The request
     * @return The XPage to display
     */
    @View( value = VIEW_APPOINTMENT_FORM_LIST, defaultView = true )
    public XPage getFormList( HttpServletRequest request )
    {
        XPage xpage = new XPage(  );
       

        return xpage;
    }

    /**
     * Get the page to complete a form
     * @param request The request
     * @return The XPage to display
     */

    //    @View( VIEW_GET_FORM )
    public XPage getViewForm( HttpServletRequest request )
    {
        String strIdForm = request.getParameter( PARAMETER_ID_FORM );
        
//        if(_appointmentFormService.getAppointmentFromSession( request.getSession(  )).getIdSlot(  )!=0)
//        {
//
//        idSlot = _appointmentFormService.getAppointmentFromSession( request.getSession(  )).getIdSlot(  );
//        }
//
//        //AppointmentSlot appointmentSlot = AppointmentSlotHome.findByPrimaryKey( idSlot );

      

        return redirectView( request, VIEW_APPOINTMENT_FORM_LIST );
    }

    /*WORKFLOW FUTURE
        private State getStatus( int nIdForm)
        {
                State retour = null;
                AppointmentForm tmpForm = AppointmentFormHome.findByPrimaryKey( nIdForm );
                if ( tmpForm != null )
                {
                        Workflow wFlow = _stateServiceWorkFlow.findByPrimaryKey( tmpForm.getIdWorkflow() );
                        if (wFlow != null)
                        {
                                retour = _stateService.getInitialState( wFlow.getId());
                        }
                }
                return retour;
        }
    */
    
    

    /**
     * Do validate data entered by a user to fill a form
     * @param request The request
     * @param ddd The request
     * @return The next URL to redirect to
     * @throws SiteMessageException
     */
    @Action( ACTION_DO_VALIDATE_FORM )
    public XPage doValidateForm( HttpServletRequest request )
        throws SiteMessageException
    {
        String strIdForm = request.getParameter( PARAMETER_ID_FORM );
        String strIdSlot = request.getParameter(PARAMETER_ID_SLOT);
      

        return redirectView( request, VIEW_APPOINTMENT_FORM_LIST );
    }

 
    
}
