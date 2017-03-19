using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Text;
using System.Data;

namespace EShop.Web.Admin.tool.Reserver
{
    /// <summary>
    /// ListBuyBatchManage 的摘要说明
    /// </summary>
    public class ListBuyBatchManage : IHttpHandler
    {
        public void ProcessRequest(HttpContext context)
        {
            context.Response.ContentType = "text/plain";
            String str = string.Empty;
           
            if (context.Request["pageIndex"] != null && context.Request["pageIndex"].ToString().Length > 0)
            {
                int pageIndex;   //具体的页面数
                int.TryParse(context.Request["pageIndex"], out pageIndex);
                if(context.Request["pageSize"]!=null&&context.Request["pageSize"].ToString().Length > 0)
                {
                //页面显示条数   
                int size = Convert.ToInt32(context.Request["pageSize"]);
                string data= BindSource(size,pageIndex);                
                context.Response.Write(data);
                context.Response.End();
                }
            }

           
        }       
        #region 无刷新分页
        public string BindSource(int pagesize,int page)
        { 
           BLL.TbGoods bll=new BLL.TbGoods();
           DataSet ds = bll.GetListByPage("Status='" + (int)Enum.RecordStatus.Normal + "'", "", pagesize * page + 1, pagesize * (page + 1));  //获取数据源的ds会吧。
           StringBuilder sb = new StringBuilder();
           if (ds!=null)
           {
               foreach (DataRow row in ds.Tables[0].Rows)
               {
                   sb.Append("<tr><td>");
                   sb.Append(row["GoodsUid"]);
                   sb.Append("</td><td>");
                   sb.Append(row["GoodsName"]);
                   sb.Append("</td></tr>");
               }
            }
           return sb.ToString();
        }
        #endregion


        public bool IsReusable
        {
            get
            {
                return false;
            }
        }
    }
}