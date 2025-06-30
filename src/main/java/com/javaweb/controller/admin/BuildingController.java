package com.javaweb.controller.admin;



import com.javaweb.constant.SystemConstant;
import com.javaweb.converter.BuildingConverter;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.enums.District;
import com.javaweb.enums.RentType;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingSearchRequest;
import com.javaweb.model.response.BuildingSearchResponse;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.security.utils.SecurityUtils;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.BuildingService;
import com.javaweb.utils.DisplayTagUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller(value="buildingControllerOfAdmin")
public class BuildingController {

    @Autowired
    private IUserService userService;
    @Autowired
    private IBuildingService searchBuilildingService;
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private BuildingConverter buildingConverter;
    @Autowired
    private BuildingService buildingService;

    @GetMapping("/admin/building-list")
    public ModelAndView getAllBuilding(@ModelAttribute("modelSearch") BuildingSearchRequest buildingSearchRequest,  HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("admin/building/list");
        DisplayTagUtils.of(request, buildingSearchRequest);
        if(SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)){
            Long staffId = SecurityUtils.getPrincipal().getId();
            buildingSearchRequest.setStaffId(staffId);
        }
        int totalItems = searchBuilildingService.countTotalItems(buildingSearchRequest);
        buildingSearchRequest.setTotalItems(totalItems);
        List<BuildingSearchResponse> results = searchBuilildingService.findAll(buildingSearchRequest);
        buildingSearchRequest.setListResult(results);
        modelAndView.addObject("modelSearch", buildingSearchRequest);
        modelAndView.addObject("staffs", userService.getStaffs());
        modelAndView.addObject("district", District.getDistrict());
        modelAndView.addObject("type", RentType.rentType());
//        List<BuildingSearchResponse> results = searchBuilildingService.findAll(buildingSearchRequest);
        modelAndView.addObject("buildingSearchResponses", results);
        return modelAndView;
    }

    @GetMapping("/admin/building-edit")
    public ModelAndView createBuilding(@ModelAttribute BuildingDTO buildingDTO){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        modelAndView.addObject("district", District.getDistrict());
        modelAndView.addObject("type", RentType.rentType());
        modelAndView.addObject("buildingEdit", buildingDTO);
        return modelAndView;
    }

    @GetMapping("/admin/building-edit-{id}")
    public ModelAndView updateBuilding(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("admin/building/edit");
        BuildingEntity buildingEntity = buildingRepository.findById(id).get();
        if(SecurityUtils.getAuthorities().contains(SystemConstant.ADMIN_ROLE)){
            Long staffId = SecurityUtils.getPrincipal().getId();
            if (buildingService.checkAssignedBuildings(id, staffId) == false) {
                modelAndView.setViewName("redirect:/error/404");
                return modelAndView;
            }
        }
        modelAndView.addObject("district", District.getDistrict());
        modelAndView.addObject("type", RentType.rentType());
        BuildingDTO buildingDTO = buildingConverter.toBuildingUpdateDTO(buildingEntity);
        modelAndView.addObject("buildingEdit", buildingDTO);
        return modelAndView;
    }
}
