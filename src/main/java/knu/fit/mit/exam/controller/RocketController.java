package knu.fit.mit.exam.controller;

import knu.fit.mit.exam.entity.RocketEntity;
import knu.fit.mit.exam.repository.RocketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
@RestController
@RequestMapping("/api/officers")
@Slf4j
public class RocketController {
    @Autowired
    RocketRepository RocketRepository;
    @GetMapping("/get")
    public List<RocketEntity> getEntities(){
        List<RocketEntity> list;
        log.info("[OFFICER CONTROLLER] Before GET");
        list = RocketRepository.findAll();
        log.info("[OFFICER CONTROLLER] After GET Found {} officers", list.size());
        return list;
        @PostMapping("/post")
        @ResponseStatus(HttpStatus.CREATED)
        public RocketEntity postEntity(@RequestBody RocketEntity RocketEntity){
            log.info("[OFFICER CONTROLLER] After POST Found new officer {} ", RocketEntity);
            return officerRepository.save(RocketEntity);
        }
        @PostMapping("/post")
        @ResponseStatus(HttpStatus.CREATED)
        public RocketEntity postEntity(@RequestBody RocketEntity RocketEntity){
            log.info("[OFFICER CONTROLLER] After POST Found new officer {} ", RocketEntity);
            return RocketRepository.save(RocketEntity);
        }

        @PutMapping("/update/{id}")
        public RocketEntity putEntity(@PathVariable long id, @RequestBody RocketEntity newEntity){
            RocketEntity updatedEntity = RocketRepository.findById(id)
                    .orElseThrow(() -> new ResourceAccessException("Not found OfficerEntity with id: " + id));
            updatedEntity.setName(newEntity.getName());
            updatedEntity.setCaliber(newEntity.getCaliber());
            updatedEntity.setMass(newEntity.getMass());
            updatedEntity.setImg(newEntity.getImg());
            updatedEntity.setCapacity(newEntity.getCapacity());
            updatedEntity.setPrice(newEntity.getPrice());
            log.info("[ROCKET CONTROLLER] After PUT Found updated officer {} ", updatedEntity);
            return RocketRepository.save(updatedEntity);
        }

        @DeleteMapping("/delete/{id}")
        public void deleteEntity(@PathVariable long id){
            RocketEntity deletedEntity = RocketRepository.findById(id)
                    .orElseThrow(()-> new ResourceAccessException("Not found pistols with id: "+id));
            log.info("[PISTOL CONTROLLER] After DELETE Found deleted pistol {} ", deletedEntity);
            RocketRepository.deleteById(id);
        }
    }